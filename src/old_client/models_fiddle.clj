(ns old-client.models-fiddle
  (:require [old-client.models :as ocm :refer :all]
            [clojure.spec.alpha :as s]))

(def good-form
  (first (create-form
   {::ocm/transcription "bonjour"
    ::ocm/translations [{::ocm/transcription "hello"
                         ::ocm/grammaticality ""}]})))

(def bad-form
  (first (create-form
          {::ocm/translations [{::ocm/transcription "hello"
                                ::ocm/grammaticality ""}]})))

(comment

  (has-transcription-value? good-form)

  (has-transcription-value? bad-form)

  (type good-form)

  (s/explain-str ::ocm/form good-form)

  (s/valid? ::ocm/form good-form)

  (+ 2 2)

  (create-form)

  (create-form {::ocm/transcription "abc"})

  (create-form {::ocm/transcription ""})

  (create-form {::ocm/transcription 134})

  (= ::ocm/a :old-client.models/a)

  (= :ocm/a :ocm/a)

  ::ocm/a

  (str 'ocm)

  (name :a)

  (name ::a)

  (= :a (keyword "a"))

  (= :a (keyword "a" "a"))

  (keyword "a" "a")

  )

