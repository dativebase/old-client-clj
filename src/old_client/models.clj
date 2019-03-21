(ns old-client.models
  (:require [clojure.set :refer [subset?]]
            [clojure.string :as string]
            [clojure.spec.alpha :as s])
  (:import java.util.Date))

(s/def ::application-settings
  (s/keys :req [::object-language-name
                ::object-language-id
                ::metalanguage-name
                ::metalanguage-id
                ::metalanguage-inventory
                ::orthographic-validation
                ::narrow-phonetic-inventory
                ::narrow-phonetic-validation
                ::broad-phonetic-inventory
                ::broad-phonetic-validation
                ::morpheme-break-is-orthographic
                ::morpheme-break-validation
                ::phonemic-inventory
                ::morpheme-delimiters
                ::punctuation
                ::grammaticalities
                ::unrestricted-users
                ::storage-orthography
                ::input-orthography
                ::output-orthography]))

(s/def ::object-language-name string?)
(s/def ::object-language-id string?)
(s/def ::metalanguage-name string?)
(s/def ::metalanguage-id string?)
(s/def ::metalanguage-inventory string?)
(s/def ::orthographic-validation #{"None" "Warning" "Error"})
(s/def ::narrow-phonetic-inventory string?)
(s/def ::narrow-phonetic-validation #{"None" "Warning" "Error"})
(s/def ::broad-phonetic-inventory string?)
(s/def ::broad-phonetic-validation #{"None" "Warning" "Error"})
(s/def ::morpheme-break-is-orthographic string?)
(s/def ::morpheme-break-validation #{"None" "Warning" "Error"})
(s/def ::phonemic-inventory string?)
(s/def ::morpheme-delimiters string?)
(s/def ::punctuation string?)
(s/def ::grammaticalities string?)
(s/def ::unrestricted_users (s/coll-of int?))  ;; A list of user ids
(s/def ::storage_orthography (s/nilable int?))
(s/def ::input_orthography (s/nilable int?))
(s/def ::output_orthography (s/nilable int?))

(def application-settings
  {:object_language_name ""
   :object_language_id ""
   :metalanguage_name ""
   :metalanguage_id ""
   :metalanguage_inventory ""
   :orthographic_validation "None"  ;; Value should be one of ["None" "Warning" "Error"]
   :narrow_phonetic_inventory ""
   :narrow_phonetic_validation "None"
   :broad_phonetic_inventory ""
   :broad_phonetic_validation "None"
   :morpheme_break_is_orthographic ""
   :morpheme_break_validation "None"
   :phonemic_inventory ""
   :morpheme_delimiters ""
   :punctuation ""
   :grammaticalities ""
   :unrestricted_users []         ;; A list of user ids
   :storage_orthography ""         ;; An orthography id
   :input_orthography ""           ;; An orthography id
   :output_orthography ""})          ;; An orthography id

(def collection
  {:title ""
   :type ""
   :url ""
   :description ""
   :markup_language ""
   :contents ""
   :speaker ""
   :source ""
   :elicitor ""
   :enterer ""
   :date_elicited ""
   :tags []
   :files []})

(def corpus
  {:name ""
   :description ""
   :content ""
   :form_search ""
   :tags []})

(def file
  {:name ""
   :description ""
   :date_elicited ""     ;; mm/dd/yyyy
   :elicitor ""
   :speaker ""
   :utterance_type ""
   :embedded_file_markup ""
   :embedded_file_password ""
   :tags []
   :forms []
   :file ""})       ;; file data Base64 encoded

(def file-base64
  {:filename ""         ;; Will be filtered out on update requests
   :description ""
   :date_elicited ""    ;; mm/dd/yyyy
   :elicitor ""
   :speaker ""
   :utterance_type ""
   :tags []
   :forms []
   :base64_encoded_file ""})  ;; file data Base64 encoded; will be filtered out on update requests

(def file-mpfd
  {:filename ""         ;; Will be filtered out on update requests
   :description ""
   :date_elicited ""     ;; mm/dd/yyyy
   :elicitor ""
   :speaker ""
   :utterance_type ""
   :tags_0 ""
   :forms_0 ""})

(def file-sub-ref
  {:parent_file ""
   :name ""
   :start ""
   :end ""
   :description ""
   :date_elicited ""     ;; mm/dd/yyyy
   :elicitor ""
   :speaker ""
   :utterance_type ""
   :tags []
   :forms []})

(def file-ext-host
  {:url ""
   :name ""
   :password ""
   :MIME_type ""
   :description ""
   :date_elicited ""     ;; mm/dd/yyyy
   :elicitor ""
   :speaker ""
   :utterance_type ""
   :tags []
   :forms []})

(s/def ::form
  (s/keys :req [::transcription
                ::phonetic_transcription
                ::narrow_phonetic_transcription
                ::morpheme_break
                ::grammaticality
                ::morpheme_gloss
                ::translations
                ::comments
                ::speaker
                ::elicitation_method
                ::tags
                ::syntactic_category
                ::speaker
                ::elicitor
                ::verifier
                ::source
                ::status
                ::date_elicited
                ::syntax
                ::semantics]))

(def non-empty-string-regex #"^.+$")
(s/def ::non-empty-string?
  (s/and string?
         #(re-matches non-empty-string-regex (string/trim %))))

(s/def ::translation
  (s/keys :req [::transcription
                ::grammaticality]))

(s/def ::translations (s/coll-of ::translation
                                 :min-count 1))

;; date mm/dd/yyyy
;; (def date-elicited-regex #"^(0[0-9]1[0-2])/([0-2][0-9]|3[0-1])/[0-9]{4}$")
;; (s/def ::date_elicited
;;   (s/and string? #(re-matches date-elicited-regex %)))
(s/def ::date_elicited (s/nilable (inst? (Date.))))

(s/def ::transcription string?)
(s/def ::phonetic_transcription string?)
(s/def ::narrow_phonetic_transcription string?)
(s/def ::morpheme_break string?)
(s/def ::grammaticality string?)
(s/def ::morpheme_gloss string?)
(s/def ::comments string?)
(s/def ::speaker (s/nilable int?))
(s/def ::elicitation_method (s/nilable int?))
(s/def ::tags (s/coll-of int?))
(s/def ::syntactic_category (s/nilable int?))
(s/def ::speaker (s/nilable int?))
(s/def ::elicitor (s/nilable int?))
(s/def ::verifier (s/nilable int?))
(s/def ::source (s/nilable int?))
(s/def ::status #{"tested" "requires testing"})
(s/def ::syntax string?)
(s/def ::semantics string?)

(def form
  {::transcription ""
   ::phonetic_transcription ""
   ::narrow_phonetic_transcription ""
   ::morpheme_break ""
   ::grammaticality ""
   ::morpheme_gloss ""
   ::translations [{::transcription ""
                    ::grammaticality ""}]
   ::comments ""
   ::speaker_comments ""
   ::elicitation_method nil
   ::tags []
   ::syntactic_category nil
   ::speaker nil
   ::elicitor nil
   ::verifier nil
   ::source nil
   ::status "tested"
   ::date_elicited nil
   ::syntax ""
   ::semantics ""})

(def transcription-type-keys
  [::transcription
   ::phonetic_transcription
   ::narrow_phonetic_transcription
   ::morpheme_break])

(defn keys->comma-str
  [some-keys]
  (string/join ", " (map name some-keys)))

(defn has-transcription-value?
  "Return true if one of the transcription-type keys has a non-empty value."
  [a-form]
  (->> (select-keys a-form transcription-type-keys)
       vals
       (map string/trim)
       (map seq)
       (filter identity)
       ((complement empty?))))

(defn create-form
  ([] form (create-form {}))
  ([form-map]
   (let [ret (merge form form-map)]
     (if (s/valid? ::form ret)
       (if (has-transcription-value? ret)
          [ret nil]
          [nil (format
                (str "The form could not be created. At least one non-empty"
                     " transcription-type value is required. The"
                     " transcription-type attributes are: %s.")
                (keys->comma-str transcription-type-keys))])
       [nil (s/explain-data ::form ret)]))))

(def form-search
  {:name ""
   :search ""
   :description ""
   :searcher ""})

(def morpheme-language-model
  {:name ""
   :description ""
   :corpus ""
   :vocabulary_morphology ""
   :toolkit ""
   :order ""
   :smoothing ""
   :categorial false})

(def morphology
  {:name ""
   :description ""
   :lexicon_corpus ""
   :rules_corpus ""
   :script_type "lexc"
   :extract_morphemes_from_rules_corpus false
   :rules ""
   :rich_upper true
   :rich_lower false
   :include_unknowns false})

(def morphological-parser
  {:name ""
   :phonology ""
   :morphology ""
   :language_model ""
   :description ""})

(def orthography
  {:name ""
   :orthography ""
   :lowercase false
   :initial_glottal_stops true})

(def page
  {:name ""
   :heading ""
   :markup_language ""
   :content ""
   :html ""})

(def phonology
  {:name ""
   :description ""
   :script ""})

(def source
  {:file ""
   :type ""
   :key ""
   :address ""
   :annote ""
   :author ""
   :booktitle ""
   :chapter ""
   :crossref ""
   :edition ""
   :editor ""
   :howpublished ""
   :institution ""
   :journal ""
   :key_field ""
   :month ""
   :note ""
   :number ""
   :organization ""
   :pages ""
   :publisher ""
   :school ""
   :series ""
   :title ""
   :type_field ""
   :url ""
   :volume ""
   :year ""
   :affiliation ""
   :abstract ""
   :contents ""
   :copyright ""
   :ISBN ""
   :ISSN ""
   :keywords ""
   :language ""
   :location ""
   :LCCN ""
   :mrnumber ""
   :price ""
   :size ""})

(def speaker
  {:first_name ""
   :last_name ""
   :page_content ""
   :dialect "dialect"
   :markup_language "reStructuredText"})

(def syntactic-category
  {:name ""
   :type ""
   :description ""})

(def user
  {:username ""
   :password ""
   :password_confirm ""
   :first_name ""
   :last_name ""
   :email ""
   :affiliation ""
   :role ""
   :markup_language ""
   :page_content ""
   :input_orthography nil
   :output_orthography nil})

(def models
  {:application_settings application-settings
   :collection collection
   :corpus corpus
   :file file
   :file_base64 file-base64
   :file_mpfd file-mpfd
   :file_sub_ref file-sub-ref
   :file_ext_host file-ext-host
   :form form
   :form_search form-search
   :morpheme_language_model morpheme-language-model
   :morphology morphology
   :morphological_parser morphological-parser
   :orthography orthography
   :page page
   :phonology phonology
   :source source
   :speaker speaker
   :syntactic_category syntactic-category
   :user user})
