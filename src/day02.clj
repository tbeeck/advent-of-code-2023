(ns day02)

(defn read-lines
  []
  (doall (line-seq (java.io.BufferedReader. *in*))))

(def cube-counts {:red 12
                  :green 13
                  :blue 14})

(def pair-pattern (re-pattern #"\s(\d+) (blue|red|green),?"))
(def round-pattern (re-pattern (str "(" pair-pattern "){1,3}[;\n]?")))

; check if round cubes fit with total number of cubes
(defn round-valid
  [round]
  (every?
   (fn [[k v]]
     (<= v (get cube-counts k)))
   round))

; Turn group match into dictionary of cube counts
(defn group-to-map
  [group]
  (let [matches (re-seq pair-pattern (first group))]
    (into {}
          (map
           (fn [item]
             (let [color (first item)
                   count (Integer/parseInt (second item))]
               [(keyword color) count]))
           (map
            (fn [match] (reverse (take-last 2 match)))
            matches)))))

; return list of maps of cubes found in each round of a game
(defn game-rounds
  [line]
  (let [groups (re-seq round-pattern line)]
    (map group-to-map groups)))

; return the id of the game if it's valid or 0 if it's invalid
(defn game-valid
  [line]
  (let [id (last (re-find #"Game (\d+)" line))
        rounds (game-rounds line)]
    (println id rounds)
    (if
     (every? round-valid rounds)
      (Integer/parseInt id)
      0)))

#_{:clj-kondo/ignore [:unused-binding]}
(defn -main [& args]
  (let [lines (read-lines)]
    (println (reduce + (map game-valid lines)))))
