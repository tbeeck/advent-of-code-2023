(ns day02)

(defn read-lines
  []
  (doall (line-seq (java.io.BufferedReader. *in*))))

(defn -main [&]
  (let [lines (read-lines)] 
    (println lines)))
