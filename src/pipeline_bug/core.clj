(ns pipeline-bug.core
  (:require [immutant.pipeline :as pl]))

(defrecord TestRecord [a b c])

(defn test-func-1 [test-record]
  (update-in test-record [:a] inc))

(defn test-func-2 [test-record]
  (update-in test-record [:b] inc))

(defonce test-pipeline
  (pl/pipeline :test-pipeline
               test-func-1
               test-func-2))


; (deref (test-pipeline (->TestRecord 1 2 3)) 1000 :timeout)
