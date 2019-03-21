(ns old-client.forms
  (:require [clojure.pprint :as pprint]
            [old-client.core :refer [oc-get oc-post oc-put oc-delete]]
            [old-client.resources :refer :all]))

(defn fetch-forms
  "Fetch all forms from the OLD instance."
  [old-client]
  (fetch-resources old-client :form))

(defn fetch-print-forms
  "Fetch all forms from the OLD instance and pretty-print them to stdout."
  [old-client]
  (fetch-print-resources old-client :form))

(defn fetch-form
  "Fetch form with form-id from the OLD instance."
  [old-client form-id]
  (fetch-resource old-client :form form-id))

(defn fetch-print-form
  "Fetch form with form-id from the OLD instance and print it."
  [old-client form-id]
  (fetch-print-resource old-client :form form-id))

(defn create-form
  "Create a new form defined by form-map."
  [old-client form-map]
  (create-resource old-client :form form-map))

(defn create-print-form
  "Create a new form defined by form-map and print it."
  [old-client form-map]
  (create-print-resource old-client :form form-map))

(defn update-form
  "Update existing form with form-id using form-map."
  [old-client form-id form-map]
  (update-resource old-client :form form-id form-map))

(defn update-print-form
  "Update existing form with form-id using form-map and print it."
  [old-client form-id form-map]
  (update-print-resource old-client :form form-id form-map))

(defn delete-form
  "Delete existing form with form-id."
  [old-client form-id]
  (delete-resource old-client :form form-id))

(defn delete-print-form
  "Delete existing form with form-id and print it."
  [old-client form-id]
  (delete-print-resource old-client :form form-id))

(defn search-forms
  "Search over forms using form-search."
  [old-client form-search]
  (search-resources old-client :form form-search))

(defn search-print-forms
  "Search over forms using form-search and pretty-print them to stdout."
  [old-client form-search]
  (search-print-resources old-client :form form-search))

(def default-form
  {:transcription "Hello"
   :translations [{:transcription "OLD World"
                   :grammaticality ""}]})
