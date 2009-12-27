/*
 * sulky-modules - several general-purpose modules.
 * Copyright (C) 2007-2009 Joern Huxhorn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.huxhorn.sulky.codec.streaming;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPStreamingEncoderWrapper<E>
	implements StreamingEncoder<E>
{
	private final StreamingEncoder<E> wrapped;

	public GZIPStreamingEncoderWrapper(StreamingEncoder<E> wrapped)
	{
		this.wrapped = wrapped;
	}

	public void encode(E obj, OutputStream into) throws IOException
	{
		GZIPOutputStream gos=new GZIPOutputStream(into);
		wrapped.encode(obj, gos);
		gos.finish();
	}
}