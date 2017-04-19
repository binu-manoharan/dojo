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
isPrime x = let series = [2..(truncate(sqrt (fromIntegral x)))]
            in null $ filter (\y -> isPerfectlyDivisible x y) series

isPerfectlyDivisible:: Int -> Int -> Bool
isPerfectlyDivisible x y = x `mod` y == 0


