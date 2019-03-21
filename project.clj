(defproject org.onlinelinguisticdatabase/old-client "0.1.0"
  :description "An HTTP client for the Online Linguistic Database (OLD)"
  :url "http://www.onlinelinguisticdatabase.org/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [cheshire "5.8.1"]
                 [inflections "0.13.2"]
                 [clj-http "3.9.1"]]
  :repl-options {:init-ns old-client.core})
