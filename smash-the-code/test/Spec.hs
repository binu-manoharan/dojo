import Test.Hspec
import Lib

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

    it "should apply gravity on the grid" $ do
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

-- TODO Make the block drop on the grid

