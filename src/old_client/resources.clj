(ns old-client.resources
  (:require [clojure.pprint :as pprint]
            [clojure.string :as string]
            [inflections.core :refer [plural]]
            [old-client.core :refer [oc-get oc-post oc-put oc-delete]]
            [old-client.print :refer [print-resource]]
            [old-client.models :refer [models]]))

(defn rsrc-kw->plrl
  [rsrc-kw] (-> rsrc-kw name plural))

(defn rsrc-kw->path
  [rsrc-kw]
  (-> rsrc-kw
      rsrc-kw->plrl
      (string/replace #"-" "")))

(defn fetch-resources
  "Fetch all resources from the OLD instance."
  [old-client rsrc-kw]
  (oc-get old-client (rsrc-kw->path rsrc-kw)))

(defn fetch-print-resources
  "Fetch all resources from the OLD instance and pretty-print them to stdout."
  [old-client rsrc-kw]
  (doseq [resource (fetch-resources old-client rsrc-kw)]
    (print-resource resource rsrc-kw)))

(defn fetch-resource
  "Fetch resource with resource-id from the OLD instance."
  [old-client rsrc-kw resource-id]
  (oc-get old-client (format "%s/%s" (rsrc-kw->path rsrc-kw) resource-id)))

(defn fetch-print-resource
  "Fetch resource with resource-id from the OLD instance and print it."
  [old-client rsrc-kw resource-id]
  (print-resource (fetch-resource old-client rsrc-kw resource-id) rsrc-kw))

(defn create-resource
  "Create a new resource defined by resource-map."
  [old-client rsrc-kw resource-map]
  (oc-post old-client
           (rsrc-kw->path rsrc-kw)
           (merge (rsrc-kw models) resource-map)))

(defn create-print-resource
  "Create a new resource defined by resource-map and print it."
  [old-client rsrc-kw resource-map]
  (print-resource (create-resource old-client rsrc-kw resource-map) rsrc-kw))

(defn update-resource
  "Update existing resource with resource-id using resource-map."
  [old-client rsrc-kw resource-id resource-map]
  (oc-put old-client
          (format "%s/%s" (rsrc-kw->path rsrc-kw) resource-id)
          (merge (rsrc-kw models) resource-map)))

(defn update-print-resource
  "Update existing resource with resource-id using resource-map and print it."
  [old-client rsrc-kw resource-id resource-map]
  (print-resource
    (update-resource old-client rsrc-kw resource-id resource-map) rsrc-kw))

(defn delete-resource
  "Delete existing resource with resource-id."
  [old-client rsrc-kw resource-id]
  (oc-delete old-client (format "%s/%s" (rsrc-kw->path rsrc-kw) resource-id)))

(defn delete-print-resource
  "Delete existing resource with resource-id and print it."
  [old-client rsrc-kw resource-id]
  (print-resource (delete-resource old-client rsrc-kw resource-id) rsrc-kw))

(defn search-resources
  "Search over resources using resource-search."
  [old-client rsrc-kw resource-search]
  (oc-post old-client
           (format "%s/search" (rsrc-kw->path rsrc-kw))
           resource-search))

(defn search-print-resources
  "Search over resources using resource-search and pretty-print them to stdout."
  [old-client rsrc-kw resource-search]
  (doseq [resource (search-resources old-client rsrc-kw resource-search)]
    (print-resource resource rsrc-kw)))
