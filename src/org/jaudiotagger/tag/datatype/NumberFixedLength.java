/**
 *  @author : Paul Taylor
 *  @author : Eric Farng
 *
 *  Version @version:$Id$
 *
 *  MusicTag Copyright (C)2003,2004
 *
 *  This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser
 *  General Public  License as published by the Free Software Foundation; either version 2.1 of the License,
 *  or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 *  the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License along with this library; if not,
 *  you can get a copy from http://www.opensource.org/licenses/lgpl-license.php or write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 * Description:
 *  Represents a Number of a fixed number of decimal places.
 */
package org.jaudiotagger.tag.datatype;

import org.jaudiotagger.tag.id3.ID3Tags;
import org.jaudiotagger.tag.AbstractTagFrameBody;
import org.jaudiotagger.tag.InvalidDataTypeException;


/** Represents a number held as a fixed number of digits */
public class NumberFixedLength
    extends AbstractDataType
{
    /**
     * Creates a new ObjectNumberFixedLength datatype.
     *
     * @param identifier 
     * @param size       the number of significant places that the number is held to
     * @throws IllegalArgumentException 
     */
    public NumberFixedLength(String identifier, AbstractTagFrameBody frameBody, int size)
    {
        super(identifier, frameBody);
        if (size < 0)
        {
            throw new IllegalArgumentException("Length is less than zero: " + size);
        }
        this.size = size;

    }

    public NumberFixedLength(NumberFixedLength copy)
    {
        super(copy);
        this.size = copy.size;
    }


    /**
     * Set Size in Bytes of this Object
     *
     * @param size in bytes that this number will be held as
     */
    public void setSize(int size)
    {
        if (size > 0)
        {
            this.size = size;
        }
    }

    /**
     * Return size
     *
     * @return the size of this number
     */
    public int getSize()
    {
        return size;
    }

    /**
     * 
     *
     * @param obj 
     * @return true if obj equivalent to this
     */
    public boolean equals(Object obj)
    {
        if ((obj instanceof NumberFixedLength) == false)
        {
            return false;
        }
        NumberFixedLength object = (NumberFixedLength) obj;
        if (this.size != object.size)
        {
            return false;
        }
        return super.equals(obj);
    }

    /**
     * Read the number from the byte array
     *
     * @param arr    
     * @param offset 
     * @throws NullPointerException      
     * @throws IndexOutOfBoundsException 
     */
    public void readByteArray(byte[] arr, int offset) throws InvalidDataTypeException
    {
        if (arr == null)
        {
            throw new NullPointerException("Byte array is null");
        }
        if ((offset < 0) || (offset >= arr.length))
        {
            throw new IndexOutOfBoundsException("Offset to byte array is out of bounds: offset = " + offset +
                ", array.length = " + arr.length);
        }
        long lvalue = 0;
        for (int i = offset; i < (offset + size); i++)
        {
            lvalue <<= 8;
            lvalue += arr[i];
        }
        value = new Long(lvalue);
        logger.info("Read NumberFixedlength:" + value);
    }


    /**
     * 
     *
     * @return String representation of this datatype
     */
    public String toString()
    {
        if (value == null)
        {
            return "";
        }
        else
        {
            return value.toString();
        }
    }

    /**
     * Write data to byte array
     *
     * @return the datatype converted to a byte array
     */
    public byte[] writeByteArray()
    {
        byte[] arr;
        arr = new byte[size];
        if (value != null)
        {
            long temp = ID3Tags.getWholeNumber(value);
            for (int i = size - 1; i >= 0; i--)
            {
                arr[i] = (byte) (temp & 0xFF);
                temp >>= 8;
            }
        }
        return arr;
    }
}
