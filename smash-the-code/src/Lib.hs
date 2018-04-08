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
parseGrid = undefined

renderGrid :: Grid -> [String]
renderGrid grid = let internalArray' = internalArray grid
                      indices' = indices internalArray'
                  in error $ show indices'


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

