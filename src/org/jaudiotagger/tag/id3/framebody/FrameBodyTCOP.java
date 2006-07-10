/**
 *  Amended @author : Paul Taylor
 *  Initial @author : Eric Farng
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
 *
 */
package org.jaudiotagger.tag.id3.framebody;

import org.jaudiotagger.tag.InvalidTagException;
import org.jaudiotagger.tag.id3.ID3v23Frames;
import org.jaudiotagger.tag.id3.ID3v24Frames;

import java.nio.ByteBuffer;


public class FrameBodyTCOP extends AbstractFrameBodyTextInfo implements ID3v24FrameBody,ID3v23FrameBody
{
    /**
     * Creates a new FrameBodyTCOP datatype.
     */
    public FrameBodyTCOP()
    {
    }

    public FrameBodyTCOP(FrameBodyTCOP body)
    {
        super(body);
    }

    /**
     * Creates a new FrameBodyTCOP datatype.
     *
     * @param textEncoding DOCUMENT ME!
     * @param text         DOCUMENT ME!
     */
    public FrameBodyTCOP(byte textEncoding, String text)
    {
        super(textEncoding, text);
    }

    /**
     * Creates a new FrameBodyTCOP datatype.
     *
     * @throws java.io.IOException DOCUMENT ME!
     * @throws InvalidTagException DOCUMENT ME!
     */
    public FrameBodyTCOP(ByteBuffer byteBuffer, int frameSize)
        throws java.io.IOException, InvalidTagException
    {
        super(byteBuffer, frameSize);
    }



    /**
      * The ID3v2 frame identifier
      *
      * @return the ID3v2 frame identifier  for this frame type
     */
    public String getIdentifier()
    {
        return ID3v24Frames.FRAME_ID_COPYRIGHTINFO;
    }
}