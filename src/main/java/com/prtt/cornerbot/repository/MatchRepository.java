package com.prtt.cornerbot.repository;

import com.prtt.cornerbot.cache.MatchCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MatchRepository extends CrudRepository<MatchCache, String> {
}
