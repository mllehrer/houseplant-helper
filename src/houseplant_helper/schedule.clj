(ns houseplant-helper.schedule
  (:require [houseplant-helper.client :as client]))

(defn get-day-numbers
  "gets days of schedule n on which plant with cadence c should be watered"
  [n c]
  ;;return a set because we want to use "contains?" later
  (set
   ;;use filter to return only members of collection for which something is true
   (filter
    ;; create an anonymous function to check each element in a collection
    #(zero? (mod % c))
    ;;range goes from 0 to n-1 so we want to increment n by 1
    ;;the zero day will become day 1 on our schedule.
    ;;(zero? (mod 0 n)) is always true. All plants are watered on day 1.
    (range (inc n)))))

(defn plant->days
  "map each plant to the days it needs to be watered"
  [plants]
  )

(defn water-on-day?
  "checks to see if you water a given plant on a given day"
  [day plant]
  (contains? (:day-numbers plant) day))

(defn generate-schedule
  "creates a data structure that maps the days provided to the plants that need to be watered"
  [{:keys [days plants]}]
  (let [schedule-days ;;make a collection of day numbers in the schedule
        ;;zipmap returns a map of a collection to another collection
        (zipmap
         ;;use "rest" function to remove the first element in a collection.
         ;;in this case, calendars don't have day 0 so neither should our schedule.
         (range
          ;;range goes from start value to n-1 so we want to increment n by 1
          1
          (inc days))
         ;;generate a collection of empty strings with one empty string per day in the schedule
         (repeat ""))
        ;;retrieve the plant data from the API
        plant-data (client/get plants)
        ;;use "map" to apply the same function to each element in a collection and return a new collection
        ;;in this case we are going to run our get-day-numbers function to add the days each plant should
        ;;be watered to the data about the plant
        with-day-numbers (map
                          ;;assoc adds a new key and value to a map or a new value to an existing key
                          #(assoc % :day-numbers
                                  (get-day-numbers days (:cadence %)))
                          plant-data)]
    ;;now the magic happens! We're going to make a new map where every day of the schedule is mapped
    ;;to a list of plants that need to be watered on that day
    (for [day schedule-days]
      (if (contains? )))
    ))


