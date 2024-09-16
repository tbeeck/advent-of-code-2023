(ns day02)

(defn read-lines
  []
  (doall (line-seq (java.io.BufferedReader. *in*))))

(def cube-counts {:red 12
                  :green 13
                  :blue 14})

(def pair-pattern (re-pattern #"\s(\d+) (blue|red|green),?"))
(def round-pattern (re-pattern (str "(" pair-pattern "){1,3}(;|\n)")))

#_{:clj-kondo/ignore [:unused-binding]}
;; (defn -main [& args]
;;   (let [lines (read-lines)]
;;     (doseq [line lines]
;;       (println line (pair-list line)))))
(defn -main [& args]
  (let [lines (read-lines)]
    (doseq [l lines
            :let [groups (re-seq round-pattern l)]]
      (println)
      (doseq [group groups
              :let [pairs (re-seq pair-pattern (first group))]]
          (println (first group) (map first pairs))))))
