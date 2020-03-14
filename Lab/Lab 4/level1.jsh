/open Box.java
/open BooleanCondition.java
/open DivisibleBy.java
/open LongerThan.java
/open Transformer.java
/open LastDigitsOfHashCode.java
/open BoxIt.java
Box.of(4)
Box.of(4).equals(Box.of(4))
Box.of(4).equals(4)
Box.of(Box.of(0)).equals(Box.of(0))
Box.of(Box.of(0)).equals(Box.of(Box.of(0)))
Box.of("string")
Box.of("string").equals(Box.of(4))
Box.of("string").equals(Box.of("null"))
Box.of("delights").equals(Box.of("chocolates"))
Box.of(null)
Box.of(null).equals(Box.ofNullable(null))
/exit
