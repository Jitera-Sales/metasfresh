/*
 * #%L
 * de.metas.adempiere.adempiere.base
 * %%
 * Copyright (C) 2024 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package de.metas.cache.rest;

import com.google.common.collect.ImmutableList;
import de.metas.util.GuavaCollectors;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.stream.Collector;

@Value
public class JsonGetStatsResponse
{
	int count;
	@NonNull List<JsonCacheStats> stats;

	@Builder
	@Jacksonized
	private JsonGetStatsResponse(@NonNull final List<JsonCacheStats> stats)
	{
		this.count = stats.size();
		this.stats = ImmutableList.copyOf(stats);
	}

	public static Collector<JsonCacheStats, ?, JsonGetStatsResponse> collect()
	{
		return GuavaCollectors.collectUsingListAccumulator(JsonGetStatsResponse::new);
	}
}
