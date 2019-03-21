================================================================================
  OLD Client for Clojure
================================================================================

An HTTP client library for the Online Linguistic Database (OLD) written in
Clojure. See http://www.onlinelinguisticdatabase.org/ and
https://github.com/dativebase.


Installation
================================================================================

Declare it as a dependency in your ``project.clj`` file::

    [org.onlinelinguisticdatabase/old-client "0.1.0"]

And/or clone the source from GitHub::

    $ git clone https://github.com/dativebase/old-client-clj.git


Usage
================================================================================

Require some of the OLD client's useful functions in your Clojure namespace::

    (:require [old-client.resources :refer [create-resource
                                            update-resource
                                            fetch-resources
                                            delete-resource
                                            search-resources]]
              [old-client.models :as ocm :refer [form create-form]]
              [old-client.core :refer [make-old-client]])

Constructing an OLD client instance is a necessary first step for most other
actions. This will perform an authentication request to confirm that the
supplied credentials are valid::

    (let [client
          (make-old-client {:url "https://some.domain.org/my/old/"
                            :username "some-username"
                            :password "some-password"})]
      ...)

To create a form::

    (let [my-form
          (create-form
            {::ocm/transcription "malheureusement"
             ::ocm/morpheme_break "mal-heureux-ment"
             ::ocm/morpheme_gloss "badly-happy-ADV"
             ::ocm/translations
             (list {::ocm/transcription "sadly"
                    ::ocm/grammaticality ""}))]
      (create-resource client :form my-form))


License
================================================================================

Copyright © 2019 Joel Dunham

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
