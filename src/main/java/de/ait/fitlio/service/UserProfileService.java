package de.ait.fitlio.service;

import de.ait.fitlio.model.User;
import de.ait.fitlio.model.UserProfile;

public interface UserProfileService {

    public UserProfile createUserProfileForUser(User user);
    public UserProfile getUserProfile(Long id);
    public UserProfile updateUserProfile(final Long id, UserProfile userProfile);
    public UserProfile deleteUserProfile(Long id);
}
