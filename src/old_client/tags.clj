(ns old-client.tags
  (:require [clojure.pprint :as pprint]
            [old-client.core :refer [oc-get oc-post oc-put oc-delete make-old-client]]
            [old-client.resources :refer :all]))

(defn fetch-tags
  "Fetch all tags from the OLD instance."
  [old-client]
  (fetch-resources old-client :tag))

(defn fetch-print-tags
  "Fetch all tags from the OLD instance and pretty-print them to stdout."
  [old-client]
  (fetch-print-resources old-client :tag))

(defn fetch-tag
  "Fetch tag with tag-id from the OLD instance."
  [old-client tag-id]
  (fetch-resource old-client :tag tag-id))

(defn fetch-print-tag
  "Fetch tag with tag-id from the OLD instance and print it."
  [old-client tag-id]
  (fetch-print-resource old-client :tag tag-id))

(defn create-tag
  "Create a new tag defined by tag-map."
  [old-client tag-map]
  (create-resource old-client :tag tag-map))

(defn create-print-tag
  "Create a new tag defined by tag-map and print it."
  [old-client tag-map]
  (create-print-resource old-client :tag tag-map))

(defn update-tag
  "Update existing tag with tag-id using tag-map."
  [old-client tag-id tag-map]
  (update-resource old-client :tag tag-id tag-map))

(defn update-print-tag
  "Update existing tag with tag-id using tag-map and print it."
  [old-client tag-id tag-map]
  (update-print-resource old-client :tag tag-id tag-map))

(defn delete-tag
  "Delete existing tag with tag-id."
  [old-client tag-id]
  (delete-resource old-client :tag tag-id))

(defn delete-print-tag
  "Delete existing tag with tag-id and print it."
  [old-client tag-id]
  (delete-print-resource old-client :tag tag-id))
