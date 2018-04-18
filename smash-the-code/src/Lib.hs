module Lib where

import Data.Array

someFunc :: IO ()
someFunc = putStrLn "someFunc"

data Colour = Blue | Green | Red | Yellow | Purple

data CellValue = Empty | Skull | ColourValue Colour
 
data Cell = Cell {
  value :: CellValue
}

data Grid = Grid {
  internalArray :: Array (Int, Int) Cell
      }

parseGrid :: [String] -> Grid
parseGrid inputLines = Grid {internalArray = twoDArray}
  where twoDArray = array dimensions values
        dimensions = ((0,0), (width - 1, height - 1))
        values = parseArray inputLines
        height = length inputLines
        width = length $ head inputLines

parseArray :: [String] -> [((Int, Int), Cell)]
parseArray inputLines = concat $ zipWith parseRow inputLines [0..]

parseRow :: String -> Int -> [((Int, Int), Cell)]
parseRow inputLine rowNum = zipWith3 parseCell inputLine (repeat rowNum) [0..]
                                
parseCell :: Char -> Int -> Int -> ((Int, Int), Cell)
parseCell char rowNum colNum = ((colNum, rowNum), (readCell char))

readCell :: Char -> Cell
readCell char = Cell {
  value = case char of
      '.' -> Empty
      '0' -> Skull
      '1' -> ColourValue Blue
      '2' -> ColourValue Green
      '3' -> ColourValue Red
      '4' -> ColourValue Yellow
      '5' -> ColourValue Purple
      }

renderGrid :: Grid -> [String]
renderGrid grid = let internalArray' = internalArray grid
                      indices' = indices internalArray'
                      bounds' = bounds (internalArray grid)
                      upperBound = snd bounds'
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

renderCell :: Cell -> Char
renderCell cell = case value cell of
  Empty -> '.'
  Skull -> '0'
  ColourValue c -> case c of
    Blue -> '1'
    Green -> '2'
    Red -> '3'
    Yellow -> '4'
    Purple -> '5'

