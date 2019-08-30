(ns clojure.term.colors)

(defn- escape-code
  [i]
  (str "\033[" i "m"))

(def ^:dynamic *reset* (escape-code 0))

;; Bind to true to have the colorize functions not apply coloring to
;; their arguments.
(def ^:dynamic *disable-colors* nil)

(defn color-fn [color]
  (let [color (escape-code color)]
    (fn [& args]
      (if-not *disable-colors*
        (str (clojure.string/join (map #(str color %) args)) *reset*)
        (apply str args)))))

(comment
  (do
    (require '[clojure.string :as str])

    (def ^:dynamic *colors*
      "foreground color map"
      (zipmap [:grey :red :green :yellow
               :blue :magenta :cyan :white]
              (range 30 38)))

    (def ^:dynamic *highlights*
      "background color map"
      (zipmap [:on-grey :on-red :on-green :on-yellow
               :on-blue :on-magenta :on-cyan :on-white]
              (range 40 48)))

    (def ^:dynamic *attributes*
      "attributes color map"
      (into {}
            (filter (comp not nil? key)
                    (zipmap [:bold, :dark, nil, :underline,
                             :blink, nil, :reverse-color, :concealed]
                            (range 1 9)))))
    (defn gen [m]
      (str/join "\n" (mapv (fn [[k v]]
                             (str "(def " (name k) " (color-fn " v "))"))
                         m)))
    (str (gen *colors*) "\n"
         (gen *highlights*) "\n"
         (gen *attributes*))))

(def grey (color-fn 30))
(def red (color-fn 31))
(def green (color-fn 32))
(def yellow (color-fn 33))
(def blue (color-fn 34))
(def magenta (color-fn 35))
(def cyan (color-fn 36))
(def white (color-fn 37))
(def on-grey (color-fn 40))
(def on-red (color-fn 41))
(def on-green (color-fn 42))
(def on-yellow (color-fn 43))
(def on-blue (color-fn 44))
(def on-magenta (color-fn 45))
(def on-cyan (color-fn 46))
(def on-white (color-fn 47))
(def bold (color-fn 1))
(def dark (color-fn 2))
(def underline (color-fn 4))
(def blink (color-fn 5))
(def reverse-color (color-fn 7))
(def concealed (color-fn 8))