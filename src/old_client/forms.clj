(ns old-client.forms
  (:require [clojure.pprint :as pprint]
            [old-client.core :refer [oc-get oc-post oc-put oc-delete]]
            [old-client.print :refer [print-form]]
            [old-client.models :refer [form]]))

(defn fetch-forms
  "Fetch all forms from the OLD instance."
  [old-client]
  (oc-get old-client "forms"))

(defn fetch-print-forms
  "Fetch all forms from the OLD instance and pretty-print them to stdout."
  [old-client]
  (doseq [form (fetch-forms old-client)]
    (print-form form)))

(defn fetch-form
  "Fetch form with form-id from the OLD instance."
  [old-client form-id]
  (oc-get old-client (format "forms/%s" form-id)))

(defn fetch-print-form
  "Fetch form with form-id from the OLD instance and print it."
  [old-client form-id]
  (print-form (fetch-form old-client form-id)))

(defn create-form
  "Create a new form defined by form-map."
  [old-client form-map]
  (oc-post old-client "forms" (merge form form-map)))

(defn create-print-form
  "Create a new form defined by form-map and print it."
  [old-client form-map]
  (print-form (create-form old-client form-map)))

(defn update-form
  "Update existing form with form-id using form-map."
  [old-client form-id form-map]
  (oc-put old-client (format "forms/%s" form-id) (merge form form-map)))

(defn update-print-form
  "Update existing form with form-id using form-map and print it."
  [old-client form-id form-map]
  (print-form (update-form old-client form-id form-map)))

(defn delete-form
  "Delete existing form with form-id."
  [old-client form-id]
  (oc-delete old-client (format "forms/%s" form-id)))

(defn delete-print-form
  "Delete existing form with form-id and print it."
  [old-client form-id]
  (print-form (delete-form old-client form-id)))

(defn search-forms
  "Search over forms using form-search."
  [old-client form-search]
  (oc-post old-client "forms/search" form-search))

(defn search-print-forms
  "Search over forms using form-search and pretty-print them to stdout."
  [old-client form-search]
  (doseq [form (search-forms old-client form-search)]
    (print-form form)))

(def default-form
  {:transcription "Hello"
   :translations [{:transcription "OLD World"
                   :grammaticality ""}]})
