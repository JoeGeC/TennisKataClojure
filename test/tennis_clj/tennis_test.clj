(ns tennis-clj.tennis-test
  (:require [clojure.test :refer :all]
            [tennis-clj.tennis :refer :all]))

(deftest basic-scores
  (testing "Should return scores"
    (is (= "fifteen love" (score 1 0)))
    (is (= "thirty love" (score 2 0)))
    (is (= "forty love" (score 3 0)))
    (is (= "love fifteen" (score 0 1)))
    (is (= "love thirty" (score 0 2)))
    (is (= "love forty" (score 0 3)))
    )
  )

(deftest draw-scores
  (testing "should return a draw score or deuce"
    (is (= "love all" (score 0 0)))
    (is (= "fifteen all" (score 1 1)))
    (is (= "thirty all" (score 2 2)))
    (is (= "deuce" (score 3 3)))
    (is (= "deuce" (score 4 4)))
    )
  )

(deftest advantage
  (testing "Should be advantage when 1 difference"
    (is (= "player 2 advantage" (score 3 4)))
    (is (= "player 2 advantage" (score 4 5)))
    (is (= "player 1 advantage" (score 4 3)))
    (is (= "player 1 advantage" (score 8 7)))
    (is (= "player 2 advantage" (score 8 9)))
    ))

(deftest winner
  (testing "Should have winner when winning score"
    (is (= "player 1 winner" (score 4 0)))
    (is (= "player 1 winner" (score 4 1)))
    (is (= "player 1 winner" (score 4 2)))
    (is (= "player 1 winner" (score 8 6)))
    (is (= "player 2 winner" (score 0 4)))
    (is (= "player 2 winner" (score 1 4)))
    (is (= "player 2 winner" (score 2 4)))
    (is (= "player 2 winner" (score 6 8)))
    ))