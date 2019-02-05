(ns old-client.models)

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

(def form
  {:transcription ""
   :phonetic_transcription ""
   :narrow_phonetic_transcription ""
   :morpheme_break ""
   :grammaticality ""
   :morpheme_gloss ""
   :translations [{:transcription ""
                   :grammaticality ""}]
   :comments ""
   :speaker_comments ""
   :elicitation_method ""
   :tags []
   :syntactic_category ""
   :speaker ""
   :elicitor ""
   :verifier ""
   :source ""
   :status "tested"
   :date_elicited ""      ;; mm/dd/yyyy
   :syntax ""
   :semantics ""})

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
