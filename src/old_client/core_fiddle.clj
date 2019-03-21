(ns old-client.core-fiddle
  (:require [clojure.pprint :as pprint]
            [old-client.core :refer [make-old-client path-to-url]]
            [old-client.print :refer [print-form]]
            [old-client.models :refer [form]]
            [old-client.resources :refer :all]
            [old-client.tags :refer :all]
            [old-client.forms :refer :all] :reload-all))

(comment

  (fetch-print-tags (make-old-client))

  (fetch-print-resources (make-old-client) :tag)

  (fetch-forms (make-old-client))

  (search-print-forms
    (make-old-client)
    {:query {:filter ["Form" "transcription" "regex" "^H"]}})

  (fetch-print-form (make-old-client) 21)

  (create-form (make-old-client) default-form)

  (create-print-form (make-old-client) default-form)

  (update-print-form
    (make-old-client)
    17
    {:transcription "a monkeys"
     :translations [{:transcription "Des singes"
                     :grammaticality ""}]})

  (delete-print-form (make-old-client) 1)

  (create-resource (make-old-client)
                   :syntactic-category
                   {:name "fart"
                    :description "Y'know."
                    :type "sentential"})

  (rsrc-kw->path :syntactic-category)

  (make-old-client)

  (path-to-url (make-old-client) (rsrc-kw->path :syntactic-category))

)
