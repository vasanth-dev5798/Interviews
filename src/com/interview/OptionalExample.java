package com.interview;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {

		String[] words = new String[10];

		String word = Optional.ofNullable(words[5]).orElse("Other");

		System.out.println(word);

		System.out.println("--- 1. CREATING OPTIONAL OBJECTS ---");
		// Optional.of(value): Throws NullPointerException if the value is null
		Optional<String> fullOptional = Optional.of("Java Programming");
		System.out.println("Optional.of: " + fullOptional);

		// Optional.empty(): Creates an empty container representing 'no value'
		Optional<String> emptyOptional = Optional.empty();
		System.out.println("Optional.empty: " + emptyOptional);

		// Optional.ofNullable(value): Safely handles nulls by returning empty if null
		String nullableValue = null;
		Optional<String> dynamicOptional = Optional.ofNullable(nullableValue);
		System.out.println("Optional.ofNullable (with null): " + dynamicOptional);

		System.out.println("\n--- 2. CHECKING & VALUATING VALUE PRESENCE ---");
		// isPresent(): Returns true if a value exists
		System.out.println("fullOptional.isPresent(): " + fullOptional.isPresent());
		System.out.println("emptyOptional.isPresent(): " + emptyOptional.isPresent());

		// isEmpty(): Returns true if the container is empty (Added in Java 11)
		System.out.println("emptyOptional.isEmpty(): " + emptyOptional.isEmpty());

		System.out.println("\n--- 3. CONDITIONAL ACTIONS (CONSUMERS) ---");
		// ifPresent(Consumer): Executes code only if a value is there
		fullOptional.ifPresent(val -> System.out.println("ifPresent triggered: Value is " + val));
		emptyOptional.ifPresent(val -> System.out.println("This will not print"));

		// ifPresentOrElse(Consumer, Runnable): Handles both present and absent states
		// (Added in Java 9)
		emptyOptional.ifPresentOrElse(val -> System.out.println("Found: " + val),
				() -> System.out.println("ifPresentOrElse triggered: No value found!"));

		System.out.println("\n--- 4. RETRIEVING VALUES & FALLBACKS ---");
		// get(): Directly extracts value. Warning: Throws NoSuchElementException if
		// empty!
		System.out.println("get(): " + fullOptional.get());

		// orElse(fallbackValue): Returns fallback value if empty
		System.out.println("orElse (fallback): " + emptyOptional.orElse("Default Value"));

		// orElseGet(Supplier): Computes fallback lazily using a lambda function
		System.out.println("orElseGet (lazy fallback): " + emptyOptional.orElseGet(() -> "Computed Default"));

		// or(Supplier): Returns an alternative Optional container if empty (Added in
		// Java 9)
		Optional<String> alternative = emptyOptional.or(() -> Optional.of("Backup Optional"));
		System.out.println("or (alternative container): " + alternative.get());

		System.out.println("\n--- 5. TRANSFORMING & FILTERING VALUES ---");
		// map(Function): Transforms the internal value safely
		Optional<Integer> lengthOptional = fullOptional.map(String::length);
		System.out.println("map (transform to length): " + lengthOptional.orElse(0));

		// flatMap(Function): Transforms value when the mapper function itself returns
		// an Optional
		Optional<String> upperOptional = fullOptional.flatMap(val -> Optional.of(val.toUpperCase()));
		System.out.println("flatMap (unwrap transformation): " + upperOptional.orElse(""));

		// filter(Predicate): Keeps the value if it matches a condition, otherwise
		// becomes empty
		Optional<String> filteredMatch = fullOptional.filter(val -> val.contains("Java"));
		Optional<String> filteredNoMatch = fullOptional.filter(val -> val.contains("Python"));
		System.out.println("filter (matching condition): " + filteredMatch);
		System.out.println("filter (non-matching condition): " + filteredNoMatch);

		System.out.println("\n--- 6. STREAM INTEROPERABILITY ---");
		// stream(): Converts the Optional directly into a Java Stream (Added in Java 9)
		long count = fullOptional.stream().count();
		System.out.println("stream().count(): " + count);

		System.out.println("\n--- 7. EXCEPTION HANDLING ---");
		// orElseThrow(): Throws NoSuchElementException if empty (Implicitly preferred
		// over get())
		try {
			fullOptional.orElseThrow();
			System.out.println("orElseThrow() on present value succeeded.");
		} catch (Exception e) {
			System.out.println(e);
		}

		// orElseThrow(Supplier): Throws a custom programmer-defined exception if empty
		try {
			emptyOptional.orElseThrow(() -> new IllegalArgumentException("Custom Error: Missing context!"));
		} catch (IllegalArgumentException e) {
			System.out.println("orElseThrow triggered custom exception: " + e.getMessage());
		}

	}

}
