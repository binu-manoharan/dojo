import Test.Hspec
import SmashTheCode
import Cell

main :: IO ()
main = hspec $ do
  describe "Smash the code AI" $ do
    it "returns the first element of a list" $ do
      head [23 ..] `shouldBe` (23 :: Int)

    it "should parse and render input" $ do
      let input = [
            ".012",
            "...."
            ]
      let grid = parseGrid input
      let renderedGrid = renderGrid grid
      renderedGrid `shouldBe` input

    it "should apply gravity on the grid test 1" $ do
      let inputGrid = parseGrid [
            ".012",
            "...."
            ]
          expectedOutput = parseGrid [
            "....",
            ".012"
            ]
      let gridWithGravityApplied = applyGravity inputGrid
      gridWithGravityApplied `shouldBe` expectedOutput

    it "should apply gravity on the grid test 2" $ do
      let inputGrid = parseGrid [
            ".012",
            "..10"
            ]
          expectedOutput = parseGrid [
            "..12",
            ".010"
            ]
      let gridWithGravityApplied = applyGravity inputGrid
      gridWithGravityApplied `shouldBe` expectedOutput

    it "should apply gravity on the column" $ do
      let inputGrid = parseGrid [
            ".012",
            "...."
            ]
          expectedOutput = parseGrid [
            "..12",
            ".0.."
            ]
      let columnWithGravityApplied = applyGravityToColumn inputGrid 1
      columnWithGravityApplied `shouldBe` expectedOutput

    it "should place block in the column" $ do
      let inputGrid = parseGrid [
            "....",
            "....",
            "....",
            "...."
            ]
          block = Block { cellBottom = Red, cellTop = Blue }
          expectedOutput = Left $ parseGrid [
            "1...",
            "3...",
            "....",
            "...."
            ]
      let gridWithBlockPlaced = placeBlockInColumn inputGrid 0 block
      gridWithBlockPlaced `shouldBe` expectedOutput

    it "should not place block in the column when there is no space" $ do
      let inputGrid = parseGrid [
            "1...",
            "2...",
            "3...",
            "4..."
            ]
          block = Block { cellBottom = Red, cellTop = Blue }
          expectedOutput = Right NoSpaceInGrid
      let gridWithBlockPlaced = placeBlockInColumn inputGrid 0 block
      gridWithBlockPlaced `shouldBe` expectedOutput

    it "should place block in the column and apply gravity" $ do
      let inputGrid = parseGrid [
            "....",
            "....",
            "....",
            "...."
            ]
          block = Block { cellBottom = Red, cellTop = Blue }
          expectedOutput = Left $ parseGrid [
            "....",
            "....",
            "1...",
            "3..."
            ]
      let gridWithBlockDropped = dropBlockInColumn inputGrid 0 block
      gridWithBlockDropped `shouldBe` expectedOutput
