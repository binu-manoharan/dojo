import System.IO
import Control.Monad

data GameData = GameData {siteid :: Int, x :: Int, y :: Int, radius:: Int}
    deriving (Show)

debug :: String -> IO ()
debug = hPutStrLn stderr

renderSite :: GameData -> String
renderSite = show

-- loopPrint :: Foldable t => t String -> IO ()
loopPrint stuff = forM_ stuff debug

main :: IO ()
main = do
    hSetBuffering stdout NoBuffering -- DO NOT REMOVE
    
    -- Auto-generated code below aims at helping you parse
    -- the standard input according to the problem statement.
    
    input_line <- getLine
    let numsites = read input_line :: Int
    
    sitesData <- replicateM numsites $ do
        input_line <- getLine
        let input = words input_line
        let siteid' = read (input!!0) :: Int
        let x' = read (input!!1) :: Int
        let y' = read (input!!2) :: Int
        let radius' = read (input!!3) :: Int
        let gameData = GameData {siteid = siteid', x = x', y = y', radius = radius'}
        return (gameData)
    
    debug "Sites"
    -- let printData = map fst sitesData
    -- loopPrint $ printData
    
    -- let sites = map snd sitesData
    printSites sitesData

    -- show sitesData
    -- map (\x -> show x) sites

    loop numsites

printSites :: [GameData] -> String
printSites sites = undefined
    
-- data 
loop :: Int -> IO ()
loop numsites = do
    input_line <- getLine
    let input = words input_line
    let gold = read (input!!0) :: Int
    let touchedsite = read (input!!1) :: Int -- -1 if none
    
    debug $ "gold " ++ (show gold)
    debug $ "touched site " ++ (show touchedsite)

    sites <- replicateM numsites $ do
        input_line <- getLine
        hPutStrLn stderr input_line
        let input = words input_line
        let siteid = read (input!!0) :: Int
        let ignore1 = read (input!!1) :: Int -- used in future leagues
        let ignore2 = read (input!!2) :: Int -- used in future leagues
        let structuretype = read (input!!3) :: Int -- -1 = No structure, 2 = Barracks
        let owner = read (input!!4) :: Int -- -1 = No structure, 0 = Friendly, 1 = Enemy
        let param1 = read (input!!5) :: Int
        let param2 = read (input!!6) :: Int
        return input_line
    --hPutStrLn stderr sites
    debug "site details"
    loopPrint sites

    input_line <- getLine
    --hPutStrLn stderr sites
    let numunits = read input_line :: Int
    
    units <- replicateM numunits $ do
        input_line <- getLine
        let input = words input_line
        let x = read (input!!0) :: Int
        let y = read (input!!1) :: Int
        let owner = read (input!!2) :: Int
        let unittype = read (input!!3) :: Int -- -1 = QUEEN, 0 = KNIGHT, 1 = ARCHER
        let health = read (input!!4) :: Int
        return input_line
    
    debug "unit details"
    loopPrint units

    -- hPutStrLn stderr "Debug messages..."
    
    -- First line: A valid queen action
    -- Second line: A set of training instructions
    
    putStrLn "WAIT"
    putStrLn "TRAIN"
    
    loop numsites