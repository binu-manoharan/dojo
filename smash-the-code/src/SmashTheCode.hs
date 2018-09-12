module SmashTheCode (
  Block(..),
  dropBlockInColumn,
  placeBlockInColumn,
  parseGrid,
  NoSpaceInGrid(..),
  renderGrid,
  applyGravity,
  applyGravityToColumn,
  collapseGridAndScore,
  CollapseIterationResult(..),
  Coordinate,
  CoordinatesToCollapse(..),
  getCoordinatesToCollapse,
  getCoordinatesInGridWithColour,
  getClusters
  ) where

import qualified Data.Array as A
import Data.Array (Array, array, bounds, indices, (!), (//))
import Data.List
import Cell
import Data.Set (Set, fromList, elems) 
import qualified Data.Set as Set

data Block = Block {
  cellBottom :: Colour,
  cellTop :: Colour
  }

data Grid = Grid {
  internalArray :: Array (Int, Int) Cell
      } deriving (Eq)

instance Show Grid where
  show grid = intercalate "\n" $ renderGrid grid

parseGrid :: [String] -> Grid
parseGrid inputLines = Grid {internalArray = twoDArray}
  where twoDArray = array dimensions values
        dimensions = ((0,0), (width - 1, height - 1))
        values = parseArray inputLines
        height = length inputLines
        width = length $ head inputLines

renderGrid :: Grid -> [String]
renderGrid grid = let bounds' = bounds (internalArray grid)
                      upperBound = snd bounds' -- TODO Add functions to get height and width
                      height = snd upperBound
                      rowNumbers = [0..height]
                  in map (renderRow grid) rowNumbers

renderRow :: Grid -> Int -> String
renderRow grid rowNum = let allIndices = indices (internalArray grid)
                            rowIndices = indicesForRow allIndices rowNum
                            cellValues = map (\i -> (internalArray grid) ! i) rowIndices
                            renderedCellValues = map renderCell cellValues
                        in renderedCellValues

indicesForRow :: [(Int, Int)] -> Int -> [(Int, Int)]
indicesForRow allIndices rowIndex = filter (\x -> snd x == rowIndex) allIndices

applyGravity :: Grid -> Grid
applyGravity grid = let bounds' = bounds (internalArray grid)
                        upperBound = snd bounds'
                        width = 1 + (fst upperBound)
                        colIndices = [0..(width - 1)]
                    in foldl applyGravityToColumn grid colIndices

data Column = Column [Cell] deriving (Show)

applyGravityToColumn :: Grid -> Int -> Grid
applyGravityToColumn grid colIndex = let

  (Column columnValues) = getGridColumn grid colIndex

  padding = replicate ((length columnValues) - (length nonEmptyCellValues)) Cell {value = Empty}
  nonEmptyCellValues = filter (not . isEmptyCell) columnValues
  newColumn = padding ++ nonEmptyCellValues

  indices' = [(colIndex, y) | y <- [0..((getGridHeight grid) - 1)]]
  
  updates = zip indices' newColumn
  in updateGrid grid updates



getGridColumn :: Grid -> Int -> Column
getGridColumn grid colIndex = let internalArray' = internalArray grid
                                  indices' = [(colIndex, y) | y <- [0..((getGridHeight grid) - 1)]]
                                  cells = map (\i -> internalArray' ! i) indices'
                               in Column $ cells

getGridHeight :: Grid -> Int
getGridHeight grid = (+) 1 $ snd $ snd $ bounds (internalArray grid)

data NoSpaceInGrid = NoSpaceInGrid deriving (Show, Eq)

placeBlockInColumn :: Grid -> Int -> Block -> Either Grid NoSpaceInGrid
placeBlockInColumn grid colIndex block =
  let indicesToUpdate = [(colIndex, 0), (colIndex, 1)]
      cellsToInsert = map colourCell [
        cellTop block, cellBottom block
        ]
      updates = zip indicesToUpdate cellsToInsert
      currentValuesAtIndices = map (getGridCell grid) indicesToUpdate
      hasSpace = all isEmptyCell currentValuesAtIndices
  in if (hasSpace) then
        Left $ updateGrid grid updates
     else Right NoSpaceInGrid

getGridCell :: Grid -> Coordinate -> Cell
getGridCell grid (x, y) = let internalArray' = internalArray grid
                          in internalArray' ! (x, y)

updateGrid :: Grid -> [((Int, Int), Cell)] -> Grid
updateGrid grid updates = let oldInternalArray = internalArray grid
                              newInternalArray = oldInternalArray // updates
                          in Grid {internalArray = newInternalArray}

dropBlockInColumn :: Grid -> Int -> Block -> Either Grid NoSpaceInGrid
dropBlockInColumn grid colIndex block =
  mapLeft (placeBlockInColumn grid colIndex block) applyGravity 

mapLeft :: Either a b -> (a -> c) -> Either c b
mapLeft (Left x) f = Left (f x)
mapLeft (Right y) _ = Right y

data CollapseIterationResult =
  CollapseIterationResult { grid :: Grid }

collapseGridAndScore :: Grid -> CollapseIterationResult
collapseGridAndScore grid =
  let
    oldInternalArray = internalArray grid
    oldValues = A.elems oldInternalArray
    newValues = map convertCellToEmptyCell oldValues
    updates = zip (indices oldInternalArray) newValues :: [((Int, Int), Cell)]
    newInternalArray = oldInternalArray // updates
  in
    CollapseIterationResult { grid = Grid {internalArray = newInternalArray} }

convertCellToEmptyCell :: Cell -> Cell
convertCellToEmptyCell _ = Cell { value = Empty }

type Coordinate = (Int, Int)

data CoordinatesToCollapse = CoordinatesToCollapse (Set Coordinate) | NothingToCollapse
                             deriving (Show, Eq)

getCoordinatesToCollapse :: Grid -> Coordinate -> CoordinatesToCollapse
getCoordinatesToCollapse grid coordinate = undefined

getCoordinatesInGridWithColour :: Grid -> Colour -> Set Coordinate
getCoordinatesInGridWithColour grid colour =
  let allIndices = indices (internalArray grid)
  in fromList $ filter (hasCellOfColour grid colour) allIndices

hasCellOfColour :: Grid -> Colour -> Coordinate -> Bool
hasCellOfColour grid colour coordinate = let internalArray' = internalArray grid
                                             cell = internalArray' ! coordinate
                                         in cell == colourCell colour

getClusters :: Set Coordinate -> Set (Set Coordinate)
getClusters x | Set.null x = Set.empty
getClusters coordinates = 
  let (thisCluster, remainingCoordinates) = getCluster coordinates
      otherClusters = getClusters remainingCoordinates
  in thisCluster `Set.insert` otherClusters


getCluster :: Set Coordinate -> (Set Coordinate, Set Coordinate)
getCluster x | Set.null x = error "Tried to get a cluster but wasn't given any coordinates"
getCluster coordinates =
  let firstElem = head $ elems coordinates
      thisCluster = recursiveGetCluster coordinates firstElem
      remainingCoordinates = Set.difference coordinates thisCluster
  in (thisCluster, remainingCoordinates)

recursiveGetCluster :: Set Coordinate -> Coordinate -> Set Coordinate
recursiveGetCluster allCoordinates startingCoordinate =
  let nearbyCoordinatesInSet = getNearbyCoordinatesInSet allCoordinates startingCoordinate
      filteredCoordinates = Set.delete startingCoordinate allCoordinates
      recursiveResult = map (recursiveGetCluster filteredCoordinates) nearbyCoordinatesInSet
      recursiveResult' = Set.unions recursiveResult
  in startingCoordinate `Set.insert` recursiveResult'

getNearbyCoordinatesInSet :: Set Coordinate -> Coordinate -> [Coordinate]
getNearbyCoordinatesInSet coordinates coordinate =
  filter (\x -> x `Set.member` coordinates) (getNearbyCoordinates coordinate)


getNearbyCoordinatesInGrid :: Grid -> Coordinate -> [Coordinate]
getNearbyCoordinatesInGrid grid coordinate =
  filter (isInsideGrid grid) (getNearbyCoordinates coordinate)

getNearbyCoordinates :: Coordinate -> [Coordinate]
getNearbyCoordinates (x, y) = [(x - 1, y), (x, y - 1), (x + 1, y), (x, y + 1)]

isInsideGrid :: Grid -> Coordinate -> Bool
isInsideGrid grid (x, y) = let ((minX, minY), (maxX, maxY)) = bounds (internalArray grid)
                           in minX <= x && x <= maxX && minY <= y && y <= maxY

                              
                               

  
