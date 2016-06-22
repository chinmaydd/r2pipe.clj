(ns r2pipe.core
    (:refer-clojure :exclude [read-string])
    (:require [me.raynes.conch.low-level :as sh]
              [clojure.java.io :as io]))

(defn r2-load
  "Loads a file in r2 and starts a process instance"
  [input_file]
  (def pipe (sh/proc "/usr/bin/r2" "-q0" (str input_file))))

(defn r2-print
  "Read from the r2 process(pipe) and print."
  []
  (dotimes [i (.available (get pipe :out))] (print (str (char (.read (get pipe :out)))))))

(defn r2-write
  "Write to the r2 process"
  [input]
  (.write (get pipe :in) (.getBytes (str input "\n")))
  (.flush (get pipe :in)))

(defn r2-string
  "Returns a string representation of the output shown by radare2"
  []
  (apply str (repeatedly (.available (get pipe :out)) #(str (char (.read (get pipe :out)))))))