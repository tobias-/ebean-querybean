package io.ebean.typequery;

/**
 * Base property for number types.
 *
 * @param <R> the root query bean type
 * @param <T> the number type
 */
public abstract class PBaseNumber<R,T> extends TQProperty<R> {

  /**
   * Construct with a property name and root instance.
   *
   * @param name property name
   * @param root the root query bean instance
   */
  public PBaseNumber(String name, R root) {
    super(name , root);
  }

  /**
   * Construct with additional path prefix.
   */
  public PBaseNumber(String name, R root, String prefix) {
    super(name, root, prefix);
  }


  /**
   * Is equal to.
   *
   * @param value the equal to bind value
   * @return the root query bean instance
   */
  public R eq(T value) {
    expr().eq(name, value);
    return root;
  }

  /**
   * Greater than.
   *
   * @param value the bind value
   * @return the root query bean instance
   */
  public R gt(T value) {
    expr().gt(name, value);
    return root;
  }

  /**
   * Greater than or Equal to.
   *
   * @param value the bind value
   * @return the root query bean instance
   */
  public R ge(T value) {
    expr().ge(name, value);
    return root;
  }

  /**
   * Less than.
   *
   * @param value the bind value
   * @return the root query bean instance
   */
  public R lt(T value) {
    expr().lt(name, value);
    return root;
  }


  /**
   * Less than or Equal to.
   *
   * @param value the bind value
   * @return the root query bean instance
   */
  public R le(T value) {
    expr().le(name, value);
    return root;
  }

  /**
   * Between lower and upper values.
   *
   * @param lower the lower bind value
   * @param upper the upper bind value
   * @return the root query bean instance
   */
  public R between(T lower, T upper) {
    expr().between(name, lower, upper);
    return root;
  }


  /**
   * Is equal to.
   *
   * @param value the equal to bind value
   * @return the root query bean instance
   */
  public R equalTo(T value) {
    expr().eq(name, value);
    return root;
  }

  /**
   * Greater than.
   *
   * @param value the bind value
   * @return the root query bean instance
   */
  public R greaterThan(T value) {
    expr().gt(name, value);
    return root;
  }

  /**
   * Greater than or Equal to.
   *
   * @param value the bind value
   * @return the root query bean instance
   */
  public R greaterOrEqualTo(T value) {
    expr().ge(name, value);
    return root;
  }


  /**
   * Less than.
   *
   * @param value the bind value
   * @return the root query bean instance
   */
  public R lessThan(T value) {
    expr().lt(name, value);
    return root;
  }


  /**
   * Less than or Equal to.
   *
   * @param value the bind value
   * @return the root query bean instance
   */
  public R lessOrEqualTo(T value) {
    expr().le(name, value);
    return root;
  }

  /**
   * Is in a list of values.
   *
   * @param values the list of values for the predicate
   * @return the root query bean instance
   */
  @SafeVarargs
  public final R in(T... values) {
    expr().in(name, (Object[]) values);
    return root;
  }

  /**
   * Is NOT in a list of values.
   *
   * @param values the list of values for the predicate
   * @return the root query bean instance
   */
  @SafeVarargs
  public final R notIn(T... values) {
    expr().notIn(name, (Object[]) values);
    return root;
  }

  // Additional int versions -- seems the right thing to do

  /**
   * Is equal to.
   *
   * @param value the equal to bind value
   * @return the root query bean instance
   */
  public R equalTo(int value) {
    expr().eq(name, value);
    return root;
  }

  /**
   * Greater than.
   *
   * @param value the equal to bind value
   * @return the root query bean instance
   */
  public R greaterThan(int value) {
    expr().gt(name, value);
    return root;
  }

  /**
   * Less than.
   *
   * @param value the equal to bind value
   * @return the root query bean instance
   */
  public R lessThan(int value) {
    expr().lt(name, value);
    return root;
  }


  /**
   * Is equal to.
   *
   * @param value the equal to bind value
   * @return the root query bean instance
   */
  public R eq(int value) {
    expr().eq(name, value);
    return root;
  }

  /**
   * Greater than.
   *
   * @param value the equal to bind value
   * @return the root query bean instance
   */
  public R gt(int value) {
    expr().gt(name, value);
    return root;
  }

  /**
   * Less than.
   *
   * @param value the equal to bind value
   * @return the root query bean instance
   */
  public R lt(int value) {
    expr().lt(name, value);
    return root;
  }

  /**
   * Between lower and upper values.
   *
   * @param lower the lower bind value
   * @param upper the upper bind value
   * @return the root query bean instance
   */
  public R between(int lower, int upper) {
    expr().between(name, lower, upper);
    return root;
  }
}