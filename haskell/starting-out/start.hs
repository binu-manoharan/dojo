import Data.List (sort, transpose, sortBy)
import Data.Ord

-- starting out
doubleMe x = x + x
tripleMe x = x * 3

-- euler 1
multipleOf3 :: Int -> Bool
multipleOf3 x = mod x 3 == 0

multipleOf5 :: Int -> Bool
multipleOf5 x = mod x 5 == 0

multipleOf3Or5 :: Int -> Bool
multipleOf3Or5 x = multipleOf3 x || multipleOf5 x

-- combinerFunction :: (i -> b) -> (i -> b) -> (b -> b -> b) -> (i -> b)

findMultipleOf3Or5 :: Int -> [Int]
findMultipleOf3Or5 x = let allNumbers = [1..x]
                        in filter multipleOf3Or5 allNumbers

sumOfMultipleOf3Or5 :: Int -> Int
sumOfMultipleOf3Or5 = sum . findMultipleOf3Or5

-- euler 2

fibonacci :: Int -> [Int]
fibonacci 1 = [1]
fibonacci 2 = fibonacci 1 ++ [2]
fibonacci n = let seriesLength = length $ fibonacci (n - 1)
                  series = fibonacci (n - 1)
              in series ++ [series !! (seriesLength - 1) + series !! (seriesLength - 2)]

fibLessThan4M :: [Int]
fibLessThan4M = takeWhile (< 4000000) (fibonacci 100)

subOfEvenFibLessThan4M :: Int
subOfEvenFibLessThan4M = sum $ (filter even fibLessThan4M)

-- euler 3

--largestPrimeFactorOfANumber :: Int -> Int
--largestPrimeFactorOfANumber x = let primeNumbers = filter isPrime [2..x]
--                          in last $ map (\y -> isPerfectlyDivisible x y) primeNumbers
                          
largestPrimeFactorOfANumber :: Int -> Int
largestPrimeFactorOfANumber x = solve x 30

solve :: Int -> Int -> Int
solve problemNumber candidateNumber = if isNumberWeAreLookingFor problemNumber candidateNumber
                                      then candidateNumber
                                      else solve problemNumber (candidateNumber - 1) 

isNumberWeAreLookingFor :: Int -> Int -> Bool
isNumberWeAreLookingFor problemNumber candidateNumber = isPerfectlyDivisible problemNumber candidateNumber && isPrime candidateNumber
  
isPrime :: Int -> Bool
isPrime 1 = False
isPrime x = let series = [2..(truncate(sqrt (fromIntegral x)))]
            in null $ filter (\y -> isPerfectlyDivisible x y) series

isPerfectlyDivisible:: Int -> Int -> Bool
isPerfectlyDivisible x y = x `mod` y == 0


-- attempt 2
largestPrimeFactor :: [Int] -> Int -> Int
largestPrimeFactor remainingPrimes problemNumber =
  if head remainingPrimes == problemNumber
  then
    problemNumber
  else
    let firstPrime = head remainingPrimes
        isPerfectlyDivisible' = isPerfectlyDivisible problemNumber firstPrime
    in if isPerfectlyDivisible'
       then
         largestPrimeFactor remainingPrimes (problemNumber `div` firstPrime)
       else
         largestPrimeFactor (tail remainingPrimes) problemNumber


primes :: [Int]
primes = filter isPrime [2..]

-- problem 4
largestPalindromeForTheProblem  :: Int
largestPalindromeForTheProblem = maximum $ filter numberIsPalindrome allProductsForTheProblem

largestPalindromeForTheProblem2  :: Int
largestPalindromeForTheProblem2 = head $ filter numberIsPalindrome $ reverse $ sort allProductsForTheProblem

allProductsForTheProblem :: [Int]
allProductsForTheProblem = [ i * j | i <- [100..999], j <- [100..999] ]

numberIsPalindrome :: Int -> Bool
numberIsPalindrome x = let revNum = reverse $ show x
                           num = show x
                       in revNum == num
                           
-- problem 5
num1to20 :: [Int]
num1to20 = [1..20]

largestCommonMultiplier1to20 :: Int
largestCommonMultiplier1to20 = findMultiplier num1to20 1 False

findMultiplier :: [Int] -> Int -> Bool-> Int
findMultiplier numbers currentValue isComplete = let prime = safeGetMaybe $ findPrimeNumber numbers
                                                     updatedMap = map (\x -> divideIfPerfectlyDivisible x prime) numbers
                                                     newValue = currentValue * prime
                                                     newIsComplete = prime == 1
                                                 in if isComplete
                                                    then newValue
                                                    else findMultiplier updatedMap newValue newIsComplete
                                        
safeGetMaybe :: Maybe Int -> Int
safeGetMaybe Nothing = 1
safeGetMaybe (Just x) = x

-- findPrimeNumber :: [Int] -> Maybe Int
-- findPrimeNumber [x] = if isPrime x
--                      then Just x
--                      else Nothing
-- findPrimeNumber (x:xs) = if isPrime x
--                         then Just x
--                         else findPrimeNumber xs

findPrimeNumber :: [Int] -> Maybe Int
findPrimeNumber xs = case filter isPrime xs of
  [] -> Nothing
  other -> Just $ head other

-- findPrimeNumber :: [Int] -> Maybe Int
-- findPrimeNumber = headMay . (filter isPrime)

-- headMay :: [a] -> Maybe a
-- headMay = undefined
  
divideIfPerfectlyDivisible :: Int -> Int -> Int
divideIfPerfectlyDivisible x y = if isPerfectlyDivisible x y
                                 then x `div` y
                                 else x

-- problem 6

sumOfSquares :: Int -> Int
sumOfSquares 1 = 1
sumOfSquares x = (x * x) + sumOfSquares (x - 1)

squareOfSum :: Int -> Int
squareOfSum x = (sum [1..x]) ^ 2

diffBetweenSquareOfSumAndSumOfSquares :: Int -> Int
diffBetweenSquareOfSumAndSumOfSquares x = (-) (squareOfSum x) (sumOfSquares x)

--problem 7

problem7 :: Int
problem7 = primes !! 10000 -- 0 indexed

-- problem 8

number = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"

getListOfAdjacentChars :: [a] -> Int -> [[a]]
getListOfAdjacentChars [] _ = []
getListOfAdjacentChars val numOfChars
  | length val >= numOfChars =
      let thisWindow = take numOfChars val
      in thisWindow : getListOfAdjacentChars (tail val) numOfChars
  | otherwise = []

findProductOfNumericString :: String -> Int
findProductOfNumericString val = let numbers = map (\c -> read [c]) val
                                 in product numbers

problem8 :: Int
problem8 = maximum $ map (findProductOfNumericString) (getListOfAdjacentChars number 13)

-- problem 9
findHypotenuseRT :: Int -> Int -> Float
findHypotenuseRT x y = sqrt $ fromIntegral $ x ^ 2 + y ^ 2

isPythagoreanTriplet :: (Int, Int, Int) -> Bool
isPythagoreanTriplet (a, b, c) = a ^ 2 + b ^ 2 == c ^ 2

isSum1000 :: (Int, Int, Int) -> Bool
isSum1000 (a, b, c) = a + b + c == 1000

problem9 :: Int
problem9 = let allTriples = [(a, b, c) |
                   a <- [1..1000],
                   b <- [1..1000],
                   c <- [1..1000],
                   a < b,
                   b < c,
                   a + b + c == 1000,
                   isPythagoreanTriplet (a, b, c)
                                       ]
               firstElement = head allTriples
               (a, b, c) = firstElement
           in a * b * c

-- problem 10
problem10 :: Int
problem10 = sum $ takeWhile (\x -> x < 2000000) primes

-- problem 11
getHorizontalWindows :: [[Int]] -> [[Int]]
getHorizontalWindows grid' = concat $ map (\x -> getListOfAdjacentChars x 4) grid'

getVerticalWindows :: [[Int]] -> [[Int]]
getVerticalWindows grid' = concat $ map (\x -> getListOfAdjacentChars x 4) (transpose grid')

getProductMap :: [[Int]] -> [Int]
getProductMap grid' = map (\x -> product x) ((getHorizontalWindows grid') ++ (getVerticalWindows grid'))

-- last $ sortBy (comparing snd) $ map (\x -> (x, product x)) $ findRowDiagonalCoordinates $ reverse grid1

-- diagonal attempt
findRowDiagonalCoordinates :: [[Int]] -> [[Int]] --[[Coordinate]]
findRowDiagonalCoordinates grid' = map (map (getGridElement grid')) (getDiagonalCoordinates grid')

getDiagonalCoordinates :: [[Int]] -> [[Coordinate]]
getDiagonalCoordinates grid' = let startingCoordinates = [ Coordinate {x = rowIdx, y = colIdx} |
                                                           rowIdx <- [0..16],
                                                           colIdx <- [0..16]]
                                   coordinateLists = map findRowDiagonal startingCoordinates
                               in coordinateLists

findRowDiagonal :: Coordinate -> [Coordinate]
findRowDiagonal Coordinate {x = rowIdx, y = colIdx} = [Coordinate {x = rowIdx, y = colIdx},
                                  Coordinate {x = rowIdx + 1, y = colIdx + 1},
                                  Coordinate {x = rowIdx + 2, y = colIdx + 2},
                                  Coordinate {x = rowIdx + 3, y = colIdx + 3}
                                 ]
                                                      
data Coordinate = Coordinate { x:: Int, y:: Int } deriving (Show)

getGridElement :: [[Int]] -> Coordinate -> Int
getGridElement grid' coordinate = let gridY = length $ grid' !! 0
                                      gridX = length $ grid'
                                      isOutOfBounds = (x coordinate) >= gridX || (y coordinate) >= gridY
                                  in (grid' !! (x coordinate)) !! (y coordinate)
                                 
grid1 :: [[Int]]
grid1 = [
  [08, 02, 22, 97, 38, 15, 00, 40, 00, 75, 04, 05, 07, 78, 52, 12, 50, 77, 91, 08],
  [49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 00],
  [81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 03, 49, 13, 36, 65],
  [52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 02, 36, 91],
  [22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80],
  [24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50],
  [32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70],
  [67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 08, 40, 91, 66, 49, 94, 21],
  [24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72],
  [21, 36, 23, 09, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95],
  [78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 03, 80, 04, 62, 16, 14, 09, 53, 56, 92],
  [16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57],
  [86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58],
  [19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 04, 89, 55, 40],
  [04, 52, 08, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66],
  [88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69],
  [04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 08, 46, 29, 32, 40, 62, 76, 36],
  [20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 04, 36, 16],
  [20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 05, 54],
  [01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48]
  ]

-- problem 12

triangleNumbers :: [Int]
triangleNumbers = map (getTriangleNumber2) [1..]

problem12 :: Int
problem12 = head $ filter (\x -> (getNumberOfDivisors x) > 500) triangleNumbers
                

getTriangleNumber :: Int -> Int
getTriangleNumber x = sum [1..x]

getTriangleNumber2 :: Int -> Int
getTriangleNumber2 x = x * (x + 1) `div` 2

getNumberOfDivisors :: Int -> Int
getNumberOfDivisors = length . getTriangleNumberDivisors

getDivisors :: Int -> [Int]
getDivisors num = filter (\x -> isPerfectlyDivisible num x) [1..num]

getTriangleNumberDivisors :: Int -> [Int]
getTriangleNumberDivisors num = let numsqrt = floor $ sqrt $ fromIntegral  num
                                    initialFactors = filter (\x -> isPerfectlyDivisible num x) [1..numsqrt]
                                    otherFactors = reverse $ map (\x -> num `div` x) initialFactors
                                in initialFactors ++ otherFactors

-- problem 13
problem13 :: String
problem13 = take 10 $ show $ sum numbers

numbers :: [Integer]
numbers = [
  37107287533902102798797998220837590246510135740250,
  46376937677490009712648124896970078050417018260538,
  74324986199524741059474233309513058123726617309629,
  91942213363574161572522430563301811072406154908250,
  23067588207539346171171980310421047513778063246676,
  89261670696623633820136378418383684178734361726757,
  28112879812849979408065481931592621691275889832738,
  44274228917432520321923589422876796487670272189318,
  47451445736001306439091167216856844588711603153276,
  70386486105843025439939619828917593665686757934951,
  62176457141856560629502157223196586755079324193331,
  64906352462741904929101432445813822663347944758178,
  92575867718337217661963751590579239728245598838407,
  58203565325359399008402633568948830189458628227828,
  80181199384826282014278194139940567587151170094390,
  35398664372827112653829987240784473053190104293586,
  86515506006295864861532075273371959191420517255829,
  71693888707715466499115593487603532921714970056938,
  54370070576826684624621495650076471787294438377604,
  53282654108756828443191190634694037855217779295145,
  36123272525000296071075082563815656710885258350721,
  45876576172410976447339110607218265236877223636045,
  17423706905851860660448207621209813287860733969412,
  81142660418086830619328460811191061556940512689692,
  51934325451728388641918047049293215058642563049483,
  62467221648435076201727918039944693004732956340691,
  15732444386908125794514089057706229429197107928209,
  55037687525678773091862540744969844508330393682126,
  18336384825330154686196124348767681297534375946515,
  80386287592878490201521685554828717201219257766954,
  78182833757993103614740356856449095527097864797581,
  16726320100436897842553539920931837441497806860984,
  48403098129077791799088218795327364475675590848030,
  87086987551392711854517078544161852424320693150332,
  59959406895756536782107074926966537676326235447210,
  69793950679652694742597709739166693763042633987085,
  41052684708299085211399427365734116182760315001271,
  65378607361501080857009149939512557028198746004375,
  35829035317434717326932123578154982629742552737307,
  94953759765105305946966067683156574377167401875275,
  88902802571733229619176668713819931811048770190271,
  25267680276078003013678680992525463401061632866526,
  36270218540497705585629946580636237993140746255962,
  24074486908231174977792365466257246923322810917141,
  91430288197103288597806669760892938638285025333403,
  34413065578016127815921815005561868836468420090470,
  23053081172816430487623791969842487255036638784583,
  11487696932154902810424020138335124462181441773470,
  63783299490636259666498587618221225225512486764533,
  67720186971698544312419572409913959008952310058822,
  95548255300263520781532296796249481641953868218774,
  76085327132285723110424803456124867697064507995236,
  37774242535411291684276865538926205024910326572967,
  23701913275725675285653248258265463092207058596522,
  29798860272258331913126375147341994889534765745501,
  18495701454879288984856827726077713721403798879715,
  38298203783031473527721580348144513491373226651381,
  34829543829199918180278916522431027392251122869539,
  40957953066405232632538044100059654939159879593635,
  29746152185502371307642255121183693803580388584903,
  41698116222072977186158236678424689157993532961922,
  62467957194401269043877107275048102390895523597457,
  23189706772547915061505504953922979530901129967519,
  86188088225875314529584099251203829009407770775672,
  11306739708304724483816533873502340845647058077308,
  82959174767140363198008187129011875491310547126581,
  97623331044818386269515456334926366572897563400500,
  42846280183517070527831839425882145521227251250327,
  55121603546981200581762165212827652751691296897789,
  32238195734329339946437501907836945765883352399886,
  75506164965184775180738168837861091527357929701337,
  62177842752192623401942399639168044983993173312731,
  32924185707147349566916674687634660915035914677504,
  99518671430235219628894890102423325116913619626622,
  73267460800591547471830798392868535206946944540724,
  76841822524674417161514036427982273348055556214818,
  97142617910342598647204516893989422179826088076852,
  87783646182799346313767754307809363333018982642090,
  10848802521674670883215120185883543223812876952786,
  71329612474782464538636993009049310363619763878039,
  62184073572399794223406235393808339651327408011116,
  66627891981488087797941876876144230030984490851411,
  60661826293682836764744779239180335110989069790714,
  85786944089552990653640447425576083659976645795096,
  66024396409905389607120198219976047599490197230297,
  64913982680032973156037120041377903785566085089252,
  16730939319872750275468906903707539413042652315011,
  94809377245048795150954100921645863754710598436791,
  78639167021187492431995700641917969777599028300699,
  15368713711936614952811305876380278410754449733078,
  40789923115535562561142322423255033685442488917353,
  44889911501440648020369068063960672322193204149535,
  41503128880339536053299340368006977710650566631954,
  81234880673210146739058568557934581403627822703280,
  82616570773948327592232845941706525094512325230608,
  22918802058777319719839450180888072429661980811197,
  77158542502016545090413245809786882778948721859617,
  72107838435069186155435662884062257473692284509516,
  20849603980134001723930671666823555245252804609722,
  53503534226472524250874054075591789781264330331690
  ]
  
-- problem 14
problem14 :: Int
problem14 = let listOfPairs = map (\x -> (x, length (collatzSequence x))) [1..1000000]
            in fst $ head $ reverse $ sortBy comparePairs3 listOfPairs

comparePairs :: (Int, Int) -> (Int, Int) -> Ordering
comparePairs (a, b) (c, d) = if (b == d) then
                               EQ
                             else if (b < d) then
                                    LT
                                  else
                                    GT

comparePairs2 :: (Int, Int) -> (Int, Int) -> Ordering
comparePairs2 p1 p2 = let a = snd p1
                          b = snd p2
                      in compare a b

comparePairs3 :: (Int, Int) -> (Int, Int) -> Ordering
comparePairs3 = comparing snd

--comparePairsReveresed :: (Int, Int) -> (Int, Int) -> Ordering
--comparePairsReveresed = negated . comparePairs3

negated :: Ordering -> Ordering
negated GT = LT
negated LT = GT
negated EQ = EQ
                         
  
collatzRule :: Int -> Int
collatzRule num
  | num == 1 = 1
  | isPerfectlyDivisible num 2 = quot num 2
  | otherwise = 3 * num + 1

collatzSequence :: Int -> [Int]
collatzSequence num = collatzList num []

collatzList :: Int -> [Int] -> [Int]
collatzList num numbers = let newList = num : numbers
                              nextNum = collatzRule num
                          in if (num == 1)
                             then newList
                             else collatzList nextNum newList

  
-- problem 15
problem15 :: (Int, Int) -> Int
problem15 (0, _) = 1
problem15 (_, 0) = 1
problem15 (x, y) = problem15 (x - 1, y) + problem15 (x, y - 1)

pascalsTriangle :: Int -> [Int]
pascalsTriangle 1 = [1]
pascalsTriangle 2 = [1,1]
pascalsTriangle 3 = [1,2,1]
pascalsTriangle 4 = [1,3,3,1]
pascalsTriangle numRows = [1] ++ getNextPascalRow (pascalsTriangle (numRows - 1)) ++ [1]

getNextPascalRow :: [Int] -> [Int]
getNextPascalRow [] = []
getNextPascalRow (x:[]) = []
getNextPascalRow (x:y:rest) = [ x + y ] ++ getNextPascalRow (y : rest)

-- problem 16
problem16 :: Int
problem16 = sum $ map (\x -> read [x]) (show (2 ^ 1000))

--problem 17
getNameOfNumber :: Int -> String
getNameOfNumber 0 = ""
getNameOfNumber 1 = "one"
getNameOfNumber 2 = "two"
getNameOfNumber 3 = "three"
getNameOfNumber 4 = "four"
getNameOfNumber 5 = "five"
getNameOfNumber 6 = "six"
getNameOfNumber 7 = "seven"
getNameOfNumber 8 = "eight"
getNameOfNumber 9 = "nine"
getNameOfNumber 10 = "ten"
getNameOfNumber 11 = "eleven"
getNameOfNumber 12 = "twelve"
getNameOfNumber 13 = "thirteen"
getNameOfNumber 14 = "fourteen"
getNameOfNumber 15 = "fifteen"
getNameOfNumber 16 = "sixteen"
getNameOfNumber 17 = "seventeen"
getNameOfNumber 18 = "eighteen"
getNameOfNumber 19 = "nineteen"
getNameOfNumber 20 = "twenty"
getNameOfNumber 30 = "thirty"
getNameOfNumber 40 = "forty"
getNameOfNumber 50 = "fifty"
getNameOfNumber 60 = "sixty"
getNameOfNumber 70 = "seventy"
getNameOfNumber 80 = "eighty"
getNameOfNumber 90 = "ninety"
--getNameOfNumber 100 = "hundred"
getNameOfNumber 1000 = "onethousand"
getNameOfNumber x
  | x < 30 = getNameOfNumber 20 ++ getNameOfNumber (x - 20)
  | x < 40 = getNameOfNumber 30 ++ getNameOfNumber (x - 30)
  | x < 50 = getNameOfNumber 40 ++ getNameOfNumber (x - 40)
  | x < 60 = getNameOfNumber 50 ++ getNameOfNumber (x - 50)
  | x < 70 = getNameOfNumber 60 ++ getNameOfNumber (x - 60)
  | x < 80 = getNameOfNumber 70 ++ getNameOfNumber (x - 70)
  | x < 90 = getNameOfNumber 80 ++ getNameOfNumber (x - 80)
  | x < 100 = getNameOfNumber 90 ++ getNameOfNumber (x - 90)
  | x < 1000 = let numHundred = x `div` 100
                   modHundred = x `mod` 100
                   result = if (modHundred == 0)
                            then
                              (getNameOfNumber numHundred) ++ "hundred"
                            else (getNameOfNumber numHundred) ++ "hundred" ++ "and" ++ (getNameOfNumber modHundred)
               in result

problem17Data :: [String]
problem17Data = map (\x -> getNameOfNumber x) [1..1000]

problem17 :: Int
problem17 = sum $ map (length) problem17Data

-- problem 18
problem18SampleData :: [String]
problem18SampleData =
  [
    "3",
    "7 4",
    "2 4 6",
    "8 5 9 3"
  ]

parseProblem18Data :: [String] -> [[Int]]
parseProblem18Data = map (\x -> parseStringToListOfInt x)

parseStringToListOfInt :: String -> [Int]
parseStringToListOfInt str = map (\x -> read x) (words str)

data P18Node = P18Node { val:: Int, left :: Maybe P18Node, right :: Maybe P18Node } deriving (Show)

--findTrianglePaths :: [Int] -> [[Int]]
--findTrianglePaths problemData = undefined

--magicFunction :: [[Int]] -> Node
--magicFunction problemData = undefined

-- attempt 1
problem18Data :: [[Int]]
problem18Data = [[3],[7,4],[2,4,6],[8,5,9,3]]

p18parseData :: [[Int]] -> [[Int]]
p18parseData [] = []
p18parseData [x] = [x]
p18parseData (x:y:xs) = let slength = length y
                     in p18parseData $ zipWith (+) y (map (\v -> p18findValue x y v) [0..(slength - 1)]) :  xs
                      
p18findValue :: [Int] -> [Int] -> Int -> Int
p18findValue firstRow secondRow index' = let value = if (index' == 0) then
                                                    firstRow !! 0
                                                  else
                                                    if (index' == (length secondRow) - 1) then
                                                      firstRow !! (index' - 1)
                                                    else
                                                      let val1 = firstRow !! (index' - 1)
                                                          val2 = firstRow !! index'
                                                      in maximum $ val1 : val2 : []
                                                         
                                      in value

problem18Data2 :: [[Int]]
problem18Data2 = [
  [75],
  [95,64],
  [17,47,82],
  [18,35,87,10],
  [20,04,82,47,65],
  [19,01,23,75,03,34],
  [88,02,77,73,07,63,67],
  [99,65,04,28,06,16,70,92],
  [41,41,26,56,83,40,80,70,33],
  [41,48,72,33,47,32,37,16,94,29],
  [53,71,44,65,25,43,91,52,97,51,14],
  [70,11,33,28,77,73,17,78,39,68,17,57],
  [91,71,52,38,17,14,91,43,58,50,27,29,48],
  [63,66,04,68,89,53,67,30,73,16,69,87,40,31],
  [04,62,98,27,23,09,70,98,73,93,38,53,60,04,23]
  ]


-- attempt 2 - more haskellish way
p18 :: Int
p18 = let dataList = parseProblem18Data p18Data
      in maximum $ head $ p18f dataList

p18f :: [[Int]] -> [[Int]]
p18f (x:[]) = [x]
p18f (x:y:xs) = p18f $ (p18CombineList (0:x) y) : xs

p18CombineList :: [Int] -> [Int] -> [Int]
p18CombineList (a:[]) (x:[]) = [x + a]
p18CombineList (a:b:ab) (x:y:xy) = let val = maximum [a, b] 
                                   in (x + val) : p18CombineList (b:ab) (y:xy) 

p18Data :: [String]
p18Data =
  [
    "75",
    "95 64",
    "17 47 82",
    "18 35 87 10",
    "20 04 82 47 65",
    "19 01 23 75 03 34",
    "88 02 77 73 07 63 67",
    "99 65 04 28 06 16 70 92",
    "41 41 26 56 83 40 80 70 33",
    "41 48 72 33 47 32 37 16 94 29",
    "53 71 44 65 25 43 91 52 97 51 14",
    "70 11 33 28 77 73 17 78 39 68 17 57",
    "91 71 52 38 17 14 91 43 58 50 27 29 48",
    "63 66 04 68 89 53 67 30 73 16 69 87 40 31",
    "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"
  ]

-- problem 19

data Month = January | February | March | April | May | June | July | August | September | October | November | December deriving (Eq)

type Year = Int

numberOfDaysInMonth :: Year -> Month -> Int
numberOfDaysInMonth _ January = 31
numberOfDaysInMonth year February = if isLeapYear year then 29 else 28
numberOfDaysInMonth _ March = 31
numberOfDaysInMonth _ April = 30
numberOfDaysInMonth _ May = 31
numberOfDaysInMonth _ June = 30
numberOfDaysInMonth _ July = 31
numberOfDaysInMonth _ August = 31
numberOfDaysInMonth _ September = 30
numberOfDaysInMonth _ October = 31
numberOfDaysInMonth _ November = 30
numberOfDaysInMonth _ December = 31

isLeapYear :: Year -> Bool
isLeapYear year = year `mod` 400 == 0 || (year `mod` 100 /= 0 && year `mod` 4 == 0 )
