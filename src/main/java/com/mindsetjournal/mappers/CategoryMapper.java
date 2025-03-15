package com.mindsetjournal.mappers;


import com.mindsetjournal.domain.PostStatus;
import com.mindsetjournal.domain.dtos.CategoryDTO;
import com.mindsetjournal.domain.entities.Category;
import com.mindsetjournal.domain.entities.Post;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName ="calculatePostCount" )
    CategoryDTO toDto(Category category);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (null == posts) {
            return 0;
        }
        return posts .stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
