package persistence.repositories.springRepositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import persistence.entities.QuestEntity

@Repository
interface SpringQuestRepository: CrudRepository<QuestEntity, Long> {
	
}
