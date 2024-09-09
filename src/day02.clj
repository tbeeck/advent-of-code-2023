(ns day02)

(defn read-lines
  []
  (doall (line-seq (java.io.BufferedReader. *in*))))

#_{:clj-kondo/ignore [:unused-binding]}
(defn -main [& args]
  (let [lines (read-lines)] 
    (println lines)))
