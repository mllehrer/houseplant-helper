(ns houseplant-helper.schedule
  (:require [houseplant-helper.client :as client]))

;; n days per schedule
;; Generate data structure that maps each day to the plants that need to be watered
;; Every plant has name and cadence
;; divide n by cadence to determine schedule
;; output csv?

(defn get-day-numbers
  "gets days of schedule n on which plant with cadence c should be watered"
  [n c]
  ;;use filter to return only members of collection for which something is true
  (filter
   ;; create an anonymous function to check each element in a collection
   #(zero? (mod % c))
   ;; range goes from 0 to n-1 so we want to increment n by 1
   (range (inc n))))

(defn generate-schedule
  "creates a data structure that maps the days provided to the plants that need to be watered"
  [{:keys [days plants]}]
  (let [plant-data (client/get plants)
        by-cadence (group-by :cadence plant-data)]))
