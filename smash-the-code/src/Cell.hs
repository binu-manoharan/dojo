module Cell where

data Colour = Blue | Green | Red | Yellow | Purple
            deriving (Eq, Show)

data CellValue = Empty | Skull | ColourValue Colour
               deriving (Eq, Show)
 
data Cell = Cell {
  value :: CellValue
} deriving (Eq, Show)

colourCell :: Colour -> Cell
colourCell c = Cell { value = ColourValue c }

isEmptyCell :: Cell -> Bool
isEmptyCell c = (value c) == Empty

isColourCell :: Cell -> Bool
isColourCell c = (value c) /= Empty && (value c) /= Skull

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
      x -> error ("Unrecognised cell: " ++ [x])
      }

parseArray :: [String] -> [((Int, Int), Cell)]
parseArray inputLines = concat $ zipWith parseRow inputLines [0..]

parseRow :: String -> Int -> [((Int, Int), Cell)]
parseRow inputLine rowNum = zipWith3 parseCell inputLine (repeat rowNum) [0..]
                                
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

