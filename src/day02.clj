(ns day02)

(defn read-lines
  []
  (doall (line-seq (java.io.BufferedReader. *in*))))

(def cube-counts {"red" 12
                  "green" 13
                  "blue" 14})

(def pair-pattern (re-pattern #"(\s(\d+) (blue|red|green),?)"))
(def group-pattern (re-pattern (str pair-pattern "{1,3}(;|\n)")))
;; #"(\s(\d+) (red|green|blue),?){1,3}(;|\n)"
(println group-pattern)

(defn line-to-maximums
    [line]
    1)

#_{:clj-kondo/ignore [:unused-binding]}
(defn -main [& args]
  (let [lines (read-lines)]
    (doseq [l lines
            :let [groups (re-seq group-pattern l)]]
      (doseq [group groups
              :let [pairs (re-seq pair-pattern (first group))]]
          (println group pairs)))
    (println (map line-to-maximums lines))))
