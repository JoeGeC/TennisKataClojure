(ns tennis-clj.tennis)

(defn abs [n] (max n (- n)))

(defn convert-score [points]
  (get ["love" "fifteen" "thirty" "forty"] points)
  )

(defn convert-equal-score [p1points]
  (if (>= p1points 3) "deuce" (str (convert-score p1points) " all")))

(defn score-difference [p1points p2points]
  (abs (- p1points p2points)))

(defn is-advantage [p1points p2points]
    (and (and (>= p1points 3) (>= p2points 3)) (= (score-difference p1points p2points) 1))
    )

(defn player-in-lead [p1points p2points]
  (str "player " (if (> p1points p2points) "1" "2"))
  )

(defn is-winning-score [p1points p2points]
    (and (> (score-difference p1points p2points) 1) (or (>= p1points 4) (>= p2points 4)))
  )

(defn score [p1points p2points]
  (cond
    (is-winning-score p1points p2points) (str (player-in-lead p1points p2points) " winner")
    (is-advantage p1points p2points) (str (player-in-lead p1points p2points) " advantage")
    (= p1points p2points) (convert-equal-score p1points)
    :else (str (convert-score p1points) " " (convert-score p2points)))
  )

