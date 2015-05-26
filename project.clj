(defproject cljs-node "0.1.0-SNAPSHOT"
  :description "Nodejs repl for Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [org.clojure/clojurescript "0.0-3269"]
                 ;;[org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 ]
  :node-dependencies [[source-map-support "*"]
                      [blessed "*"]]
  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-npm "0.4.0"]]
  :cljsbuild {
    :builds [{
        :source-paths ["src"]
        :compiler {
          :output-to "run.js"
          :optimizations :simple
          :pretty-print true
          :target :nodejs}}]})
