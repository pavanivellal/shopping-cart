(ns pencil-project.helper.date
  (:require [clj-time.core :refer [day-of-week day month]]
            [clj-time.format :as f]
            [clj-time.core :as dt]))

(defn parse-dt-str
  "convert date string in format yyyy-MM-dd to date object"
  [date-str]
  (when date-str
    (f/parse date-str)))

(defn within-range? [date-str start-dt end-dt]
  (let [start-dt (f/parse start-dt)
        end-dt   (f/parse end-dt)
        date-o   (f/parse date-str)]
    (or (= date-o start-dt)
        (= date-o end-dt)
        (and (dt/after?  date-o start-dt)
             (dt/before? date-o end-dt)))))


(comment
  (day-of-week (dt/now))


  (within-range? "2020-10-01" "2020-01-01" "2021-01-01")

  (dt/after? (dt/now) (f/parse "2019-10-01"))
  :end)
