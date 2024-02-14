package de.ait.fitlio.service.impl;

import de.ait.fitlio.model.User;
import de.ait.fitlio.model.UserProfile;
import de.ait.fitlio.repository.UserProfileRepository;
import de.ait.fitlio.service.UserProfileService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile createUserProfileForUser(User user) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(user);
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile getUserProfile(Long id) {
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profile with id: " + id + " not found"));
    }

    @Override
    public UserProfile updateUserProfile(Long id, UserProfile userProfile) {
        return null;
    }

    @Override
    public UserProfile deleteUserProfile(Long id) {
        return null;
    }
}
