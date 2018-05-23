module SmashTheCode where

import Data.Array
import Data.List
import Cell

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
renderGrid grid = let internalArray' = internalArray grid
                      indices' = indices internalArray'
                      bounds' = bounds (internalArray grid)
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

-- TODO Use coordinates
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

  column@(Column columnValues) = getGridColumn grid colIndex

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

placeBlockInColumn :: Grid -> Int -> Block -> Grid
placeBlockInColumn grid colIndex block = let internalArray' = internalArray grid
                                             gridColumn = getGridColumn grid colIndex
                                             indicesToUpdate = [(colIndex, 0), (colIndex, 1)]
                                             cellsToInsert = map colourCell [
                                               cellTop block, cellBottom block
                                               ]
                                             updates = zip indicesToUpdate cellsToInsert
                                         in updateGrid grid updates

updateGrid :: Grid -> [((Int, Int), Cell)] -> Grid
updateGrid grid updates = let oldInternalArray = internalArray grid
                              newInternalArray = oldInternalArray // updates
                          in Grid {internalArray = newInternalArray}

             
                                             
                                             


