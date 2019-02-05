(ns old-client.core
  (:require [clj-http.client :as client]
            [clojure.string :as string]
            [old-client.utils :refer [l-strip r-strip json-stringify]]
            [old-client.config :refer [old-url-dflt old-username-dflt
                                       old-password-dflt]]
            [old-client.print :refer [print-form]]))

(defn append-path
  "Append path to url."
  [url path]
  (format "%s/%s" (r-strip "/" url) (l-strip "/" path)))

(defn path-to-url
  "Convert path to a URL."
  [old-client path]
  (append-path (:url old-client) path))

(defn get-request-func
  "Return a function that issues an HTTP request of with method."
  [method]
  (case method
    :post client/post
    :put client/put
    :delete client/delete
    client/get))

(defn issue-request
  "Send out an HTTP request and return its body as parsed JSON."
  ([old-client method path]
   (issue-request old-client method path {} {}))
  ([old-client method path body-map]
   (issue-request old-client method path body-map {}))
  ([old-client method path body-map query-params]
   (:body ((get-request-func method)
    (path-to-url old-client path)
    {:body (json-stringify body-map)
     :query-params query-params
     :content-type :json
     :accept :json
     :as :json
     :throw-entire-message? true
     :cookie-store (:cookie-store old-client)}))))

(defrecord OLDClient
  [url
   username
   password
   cookie-store])

(defn login
  "Issue a login request using old-client."
  [old-client]
  (issue-request
    old-client
    :post
    "login/authenticate"
    {:username (:username old-client)
     :password (:password old-client)}))

(defn make-old-client
  "Construct and return an OLDClient record, after attempting a login request."
  [& args]
  (let [old-client
        (map->OLDClient
          (into args {:url old-url-dflt
                      :username old-username-dflt
                      :password old-password-dflt
                      :cookie-store (clj-http.cookies/cookie-store)}))]
    (login old-client)
    old-client))

(defn oc-get
  "Issue an OLD Client GET request to path with optional query-params."
  ([old-client path] (oc-get old-client path {}))
  ([old-client path query-params]
   (issue-request old-client :get path {} query-params)))

(defn oc-post
  "Issue an OLD Client POST request to path with body-map as the
  JSON-stringified request body."
  [old-client path body-map]
  (issue-request old-client :post path body-map {}))

(defn oc-create
  "Issue an OLD Client POST request to path with body-map as the
  JSON-stringified request body."
  [old-client path body-map]
  (oc-post old-client path body-map))

(defn oc-put
  "Issue an OLD Client PUT request to path with body-map as the
  JSON-stringified request body."
  [old-client path body-map]
  (issue-request old-client :put path body-map))

(defn oc-update
  "Issue an OLD Client PUT request to path with body-map as the
  JSON-stringified request body."
  [old-client path body-map]
  (oc-put old-client path body-map))

(defn oc-delete
  "Issue an OLD Client DELETE request to path."
  [old-client path]
  (issue-request old-client :delete path))
