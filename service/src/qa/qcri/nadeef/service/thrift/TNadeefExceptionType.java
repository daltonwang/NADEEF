/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package qa.qcri.nadeef.service.thrift;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum TNadeefExceptionType implements org.apache.thrift.TEnum {
  UNKNOWN(0),
  COMPILE_ERROR(1),
  INVALID_RULE(2);

  private final int value;

  private TNadeefExceptionType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static TNadeefExceptionType findByValue(int value) { 
    switch (value) {
      case 0:
        return UNKNOWN;
      case 1:
        return COMPILE_ERROR;
      case 2:
        return INVALID_RULE;
      default:
        return null;
    }
  }
}
