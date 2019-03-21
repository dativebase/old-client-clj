(ns old-client.utils
  (:require [clojure.string :as string]
            [cheshire.core :refer [generate-string parse-string]]))

(defn l-strip
  "Left-strip pfx from s"
  [pfx s]
  (if (string/starts-with? s pfx)
    (l-strip pfx (apply str (drop (count pfx) s)))
    s))

(defn r-strip
  "Right-strip sfx from s"
  [sfx s]
  (if (string/ends-with? s sfx)
    (r-strip sfx (apply str (take (- (count s) (count sfx)) s)))
    s))

(defn json-stringify [thing] (generate-string thing {:key-fn name}))

(defn json-parse [thing] (parse-string thing true))

