(ns day01
  (:require [clojure.string :as str]))

(defn read-lines
  []
  (doall (line-seq (java.io.BufferedReader. *in*))))

(def words {"one" 1
            "two" 2
            "three" 3
            "four" 4
            "five" 5
            "six" 6
            "seven" 7
            "eight" 8
            "nine" 9})

(def digit-map
  (let [new-entries (into {} (map (fn [v] [(str v) v]) (vals words)))]
    (merge words new-entries)))

(def full-digit-map
  (let [new-entries (into {} (map (fn [k] [(apply str (reverse (seq k))) (get words k)]) (keys words)))]
    (merge digit-map new-entries)))

(def wordpattern (str/join "|" (keys full-digit-map)))

(defn first-digit
  [line]
  (when-let [digitstr (re-find (re-pattern wordpattern) line)]
    (get full-digit-map digitstr)))

(defn last-digit
  [line]
  (first-digit
   (apply str (reverse (seq line)))))

(defn parse-num
  [line]
  (+ (* (first-digit line) 10) (last-digit line)))

(defn -main [&]
  (let [lines (read-lines)]
    (doseq [l lines] (println (parse-num l)))
    (println (reduce + (map parse-num lines)))))
