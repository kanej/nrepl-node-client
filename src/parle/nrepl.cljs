(ns parle.nrepl
  (:require [parle.net :as net]
            [parle.bencode :as bencode]))

(defprotocol Repl
  (perform-op [this op callback-fn]))

(defrecord Nrepl [client port]
  Repl
  (perform-op [this op callback-fn]
    (let [encoded-op (bencode/encode op)]
      (.removeAllListeners client "data")
      (.on client "data" #(callback-fn (-> % bencode/decode)))
      (.write client encoded-op))))

(defn connect [port callback-fn]
  (net/connect port (fn [client]
                      (if (= client :ECONNREFUSED)
                        (callback-fn :ECONNREFUSED)
                        (callback-fn (->Nrepl client port))))))
