# Initialise project
- `stack new smash-the-code`
- `stack setup`
- `stack build`
- test method `stack exec smash-the-code-exe`
- run test with `stack test`
- ghci `stack ghci`
### Test snippet
```import Test.Hspec
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
```


# Wood 1 AI
