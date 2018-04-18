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

-- TODO Make the block drop on the grid
