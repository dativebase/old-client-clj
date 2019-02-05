(ns old-client.core-fiddle
  (:require [clojure.pprint :as pprint]
            [old-client.core :refer [make-old-client]]
            [old-client.print :refer [print-form]]
            [old-client.models :refer [form]]
            [old-client.forms :refer :all] :reload-all))

(comment

  (fetch-print-forms (make-old-client))

  (search-print-forms
    (make-old-client)
    {:query {:filter ["Form" "transcription" "regex" "^H"]}})

  (fetch-print-form (make-old-client) 21)

  (create-print-form (make-old-client) default-form)

  (update-print-form
    (make-old-client)
    17
    {:transcription "monkeys"
     :translations [{:transcription "Des singes"
                     :grammaticality ""}]})

  (delete-print-form (make-old-client) 18)

)
