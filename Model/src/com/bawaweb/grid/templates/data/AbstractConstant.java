/**
 * @author Nonny Medhora
 */
package com.bawaweb.grid.templates.data;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;

public abstract class AbstractConstant implements Serializable {
  private transient String _fieldName;

  private transient String shortName = null;

  private transient String longName = null;

  public AbstractConstant() {
  }

  public AbstractConstant(String shortName, String longName) {
    this.shortName = shortName;
    this.longName = longName;
  }

  public abstract Collection getValues();

  public String getShortName() {
    return shortName;
  }

  public String getLongName() {
    return longName;
  }

  public String toString() {
    return longName;
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    Class clazz = getClass();
    Field[] f = clazz.getDeclaredFields();
    for( int i = 0; i < f.length; i++ ) {
      try {
        int mod = f[i].getModifiers();
        if( Modifier.isStatic(mod) && Modifier.isFinal(mod) && Modifier.isPublic(mod) ) {
          if( this == f[i].get(null) ) {
            String fName = f[i].getName();
            out.writeObject(fName);
            break;
          }
        }
      } catch( IllegalAccessException ex ) {
        throw new IOException(ex.getMessage());
      }
    }
  }

  private void readObject(ObjectInputStream in) throws IOException {
    try {
      _fieldName = (String) in.readObject();
    } catch( ClassNotFoundException ex ) {
      throw new IOException(ex.getMessage());
    }
  }

  public Object readResolve() throws ObjectStreamException {
    try {
      Class clazz = getClass();
      Field f = clazz.getField(_fieldName);
      return f.get(null);
    } catch( Exception ex ) {
      throw new InvalidObjectException("Failed to resolve object");
    }
  }
}
